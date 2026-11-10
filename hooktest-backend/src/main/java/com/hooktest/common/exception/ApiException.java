package com.hooktest.common.exception;

public class ApiException extends RuntimeException {
   private final ErrorCode errorCode;
   private final String message;

   public ApiException(ErrorCode errorCode) {
       super(errorCode.getDefaultMessage());
       this.errorCode = errorCode;
       this.message = errorCode.getDefaultMessage();
   }

   public ApiException(ErrorCode errorCode, String message) {
      super(message);
      this.errorCode = errorCode;
      this.message = message;
   }

   public ErrorCode getErrorCode() {
      return errorCode;
   }

   @Override
   public String getMessage() {
      return message;
   }
}