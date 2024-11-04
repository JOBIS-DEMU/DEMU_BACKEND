package com.example.demu.domain.auth.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class NicknameAlreadyExistsException extends DemuException {
    public static final DemuException EXCEPTION = new NicknameAlreadyExistsException();

    public NicknameAlreadyExistsException() {
        super(ErrorCode.NICKNAME_ALREADY_EXISTS);
    }
}
