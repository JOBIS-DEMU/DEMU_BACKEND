package com.example.demu.infra.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class EmptyFileException extends DemuException {
    public static final DemuException EXCEPTION = new EmptyFileException();
    public EmptyFileException(){
        super(ErrorCode.EMPTY_FILE_EXCEPTION);
    }
}
