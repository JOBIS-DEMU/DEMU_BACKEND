package com.example.demu.global.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class JwtSigningException extends DemuException {

    public static final DemuException EXCEPTION = new JwtSigningException();

    public JwtSigningException() {
        super(ErrorCode.JwtSigningException);
    }

}
