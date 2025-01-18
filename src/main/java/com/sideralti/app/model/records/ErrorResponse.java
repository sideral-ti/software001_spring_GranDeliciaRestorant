package com.sideralti.app.model.records;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(name = "ErrorResponse")
record ErrorResponse(
        @Schema(description = "Error message")
        String message,

        @Schema(description = "HTTP Status code")
        int status,

        @Schema(description = "Error timestamp")
        LocalDateTime timestamp
) {}