package com.hooktest.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
   AUTH_INVALID_CREDENTIALS("AUTH_INVALID_CREDENTIALS", HttpStatus.UNAUTHORIZED, "Invalid email or password"),
   AUTH_TOKEN_EXPIRED("AUTH_TOKEN_EXPIRED", HttpStatus.UNAUTHORIZED, "Token expired"),
   AUTH_TOKEN_INVALID("AUTH_TOKEN_INVALID", HttpStatus.UNAUTHORIZED, "Invalid token"),
   AUTH_TOKEN_REVOKED("AUTH_TOKEN_REVOKED", HttpStatus.UNAUTHORIZED, "Token has been revoked"),
   USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NOT_FOUND, "User not found"),
   USER_ALREADY_EXISTS("USER_ALREADY_EXISTS", HttpStatus.CONFLICT, "A user with this email already exists"),
   WORKSPACE_NOT_FOUND("WORKSPACE_NOT_FOUND", HttpStatus.NOT_FOUND, "Workspace not found"),
   ENDPOINT_NOT_FOUND("ENDPOINT_NOT_FOUND", HttpStatus.NOT_FOUND, "Endpoint not found"),
   RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND, "Resource not found"),
   RESOURCE_FORBIDDEN("RESOURCE_FORBIDDEN", HttpStatus.FORBIDDEN, "User does not own this resource"),
   VALIDATION_FAILED("VALIDATION_FAILED", HttpStatus.BAD_REQUEST, "Validation failed"),
   INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error");

   private final String code;
   private final HttpStatus httpStatus;
   private final String defaultMesage;

   ErrorCode(String code, HttpStatus httpStatus, String defaultMessage) {
      this.code = code;
      this.httpStatus = httpStatus;
      this.defaultMesage = defaultMessage;
   }

   public String getCode() {
      return code;
   }

   public HttpStatus getHttpStatus() {
      return httpStatus;
   }

   public String getDefaultMessage() {
      return defaultMesage;
   }
}