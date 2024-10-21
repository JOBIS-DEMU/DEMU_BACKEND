package com.example.demu.domain.post.exception;

import com.example.demu.global.error.exception.DemuException;
import com.example.demu.global.error.exception.ErrorCode;

public class PostNotfoundException extends DemuException {

    public static final DemuException EXCEPTION = new PostNotfoundException();

    private PostNotfoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }

}
