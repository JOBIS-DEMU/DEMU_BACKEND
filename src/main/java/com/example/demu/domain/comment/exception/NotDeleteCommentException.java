package com.example.demu.domain.comment.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class NotDeleteCommentException extends DemuException {

    public static final DemuException EXCEPTION = new NotDeleteCommentException();

    private NotDeleteCommentException() {
        super(ErrorCode.CANNOT_DELETE_COMMENT);
    }

}
