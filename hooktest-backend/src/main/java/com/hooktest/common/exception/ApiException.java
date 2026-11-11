
package com.hooktest.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Map;

public class ApiException extends RuntimeException {

    private final HttpStatusCode httpStatus;
    private final String errorCode;
    private final Map<String, Object> details;

    // Predefined error
    public ApiException(ErrorCode errorCode) {
        this(errorCode, errorCode.getDefaultMessage());
    }

    // Predefined error with custom message
    public ApiException(ErrorCode errorCode, String message) {
        this(errorCode.getHttpStatus(), errorCode.getCode(), message);
    }

    // Fully dynamic error
    public ApiException(
            HttpStatusCode httpStatus,
            String errorCode,
            String message
    ) {
        this(httpStatus, errorCode, message, null);
    }

    // Dynamic error with additional details
    public ApiException(
            HttpStatusCode httpStatus,
            String errorCode,
            String message,
            Map<String, Object> details
    ) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.details = details;
    }

    public HttpStatusCode getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    // Convenience factory for custom HTTP errors
    public static ApiException of(
            int status,
            String errorCode,
            String message
    ) {
        return new ApiException(
                HttpStatusCode.valueOf(status),
                errorCode,
                message
        );
    }
}
