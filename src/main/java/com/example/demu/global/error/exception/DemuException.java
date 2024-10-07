package com.example.demu.global.error.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DemuException extends RuntimeException {
    private final ErrorCode errorCode;
}
