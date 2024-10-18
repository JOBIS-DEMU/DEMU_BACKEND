package com.example.demu.domain.post.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class CannotModifyFeedException extends DemuException {
    public static final DemuException EXCEPTION = new CannotModifyFeedException();

    public CannotModifyFeedException() {
        super(ErrorCode.CANNOT_MODIFY_POST);
    }
}
