package com.hooktest.common.exception;

import com.hooktest.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ApiException.class)
   public ResponseEntity<Map<String, Object>> handleApiException(ApiException ex) {
      ErrorCode code = ex.getErrorCode();
      Map<String, Object> body = new HashMap<>();
      body.put("success", false);
      body.put("message", ex.getMessage());
      body.put("errorCode", code.getCode());
      body.put("timedtamp", java.time.Instant.now().toString());
      return ResponseEntity.status(code.getHttpStatus()).body(body);
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
      String message = ex.getBindingResult().getFieldErrors().stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage()).findFirst().orElse("validation failed");
      Map<String, Object> body = new HashMap<>();
      body.put("success", false);
      body.put("message", message);
      body.put("errorCode", ErrorCode.VALIDATION_FAILED.getCode());
      body.put("timestamp", java.time.Instant.now().toString());
      return ResponseEntity.badRequest().body(body);
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
      org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class).error("Unhandled exception", ex);
      Map<String, Object> body = new HashMap<>();
      body.put("success", false);
      body.put("message", "Unexpected error");
      body.put("errorCode", ErrorCode.INTERNAL_SERVER_ERROR.getCode());
      body.put("timestamp", java.time.Instant.now().toString());
      return ResponseEntity.status(500).body(body);
   }
}