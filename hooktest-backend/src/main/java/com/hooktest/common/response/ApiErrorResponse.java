
package com.hooktest.common.response;

import java.time.Instant;
import java.util.Map;

public record ApiErrorResponse(
        boolean success,
        int status,
        String error,
        String errorCode,
        String message,
        String path,
        String traceId,
        Instant timestamp,
        Map<String, Object> details
) {
    public ApiErrorResponse {
        success = false;
        timestamp = timestamp == null ? Instant.now() : timestamp;
        details = details == null ? Map.of() : Map.copyOf(details);
    }
}
