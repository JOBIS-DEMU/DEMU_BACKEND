package com.example.demu.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    USER_NOT_FOUND(404, "User Not Found"),
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    POST_NOT_FOUND(404, "Post Not Found"),
    CANNOT_MODIFY_POST(403, "Cannot Modify Post");

    private final int status;
    private final String message;
}
