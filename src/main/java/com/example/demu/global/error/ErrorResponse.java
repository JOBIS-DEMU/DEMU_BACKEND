package com.example.demu.global.error;

import com.example.demu.global.error.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    private int status;
    private String message;

    public static ErrorResponse of(ErrorCode errorCode, String description) {
        return ErrorResponse.builder()
            .message(errorCode.getMessage())
            .status(errorCode.getStatus())
            .build();
    }

    public static ErrorResponse of(int statusCode, String description) {
        return ErrorResponse.builder()
            .message(description)
            .status(statusCode)
            .build();
    }
}