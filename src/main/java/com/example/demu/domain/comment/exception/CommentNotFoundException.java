package com.example.demu.domain.comment.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class CommentNotFoundException extends DemuException {

    public static final DemuException EXCEPTION =  new CommentNotFoundException();

    private CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }

}
