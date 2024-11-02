package com.example.demu.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DemuException extends RuntimeException {
    private final ErrorCode errorCode;
}
