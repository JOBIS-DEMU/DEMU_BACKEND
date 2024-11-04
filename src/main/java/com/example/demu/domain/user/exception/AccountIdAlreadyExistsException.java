package com.example.demu.domain.user.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class AccountIdAlreadyExistsException extends DemuException {

    public static final DemuException EXCEPTION = new AccountIdAlreadyExistsException();

    private AccountIdAlreadyExistsException() {
        super(ErrorCode.ACCOUNTID_ALREADY_EXISTS);
    }
}