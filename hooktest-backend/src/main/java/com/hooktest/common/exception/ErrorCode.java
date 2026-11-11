
package com.hooktest.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // Authentication
    AUTH_INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "Invalid email or password"),
    AUTH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "Token expired"),
    AUTH_TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "Invalid token"),
    AUTH_TOKEN_REVOKED(HttpStatus.UNAUTHORIZED, "Token has been revoked"),

    // User
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User already exists"),

    // Workspace
    WORKSPACE_NOT_FOUND(HttpStatus.NOT_FOUND, "Workspace not found"),
    WORKSPACE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "Workspace access denied"),

    // Endpoint
    ENDPOINT_NOT_FOUND(HttpStatus.NOT_FOUND, "Endpoint not found"),

    // Resource
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),
    RESOURCE_FORBIDDEN(HttpStatus.FORBIDDEN, "Access denied"),

    // Request
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request"),
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "Validation failed"),
    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Unsupported media type"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "Method not allowed"),

    // Security
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "Access denied"),
    RATE_LIMIT_EXCEEDED(HttpStatus.TOO_MANY_REQUESTS, "Too many requests"),

    // Server
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected server error"),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "Service unavailable"),
    GATEWAY_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT, "Gateway timeout");

    private final HttpStatus httpStatus;
    private final String defaultMessage;

    ErrorCode(HttpStatus httpStatus, String defaultMessage) {
        this.httpStatus = httpStatus;
        this.defaultMessage = defaultMessage;
    }

    public String getCode() {
        return name();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
