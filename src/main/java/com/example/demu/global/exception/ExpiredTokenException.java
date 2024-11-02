package com.example.demu.global.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class ExpiredTokenException extends DemuException {
    public static final DemuException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
