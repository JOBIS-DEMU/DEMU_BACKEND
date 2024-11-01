package com.example.demu.infra.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class NotFileException extends DemuException {
    public static final DemuException EXCEPTION = new NotFileException();
    public NotFileException (){
        super(ErrorCode.NOT_FILE_EXTENTION);
    }
}
