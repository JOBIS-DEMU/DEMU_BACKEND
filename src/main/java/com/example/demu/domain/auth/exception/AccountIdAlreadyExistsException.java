package com.example.demu.domain.auth.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class AccountIdAlreadyExistsException extends DemuException {

    public static final DemuException EXCEPTION = new AccountIdAlreadyExistsException();

    public AccountIdAlreadyExistsException() {
        super(ErrorCode.ACCOUNTID_ALREADY_EXISTS);
    }
}
