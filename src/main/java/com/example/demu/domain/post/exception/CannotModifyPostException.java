package com.example.demu.domain.post.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class CannotModifyPostException extends DemuException {

    public static final DemuException EXCEPTION = new CannotModifyPostException();

    private CannotModifyPostException() {
        super(ErrorCode.CANNOT_MODIFY_POST);
    }

}
