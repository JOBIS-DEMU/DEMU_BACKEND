package com.example.demu.infra.exception;


import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class IoException extends DemuException {
    public static final DemuException EXCEPTION = new IoException();

    public IoException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
