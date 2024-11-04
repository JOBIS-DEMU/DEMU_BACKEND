package com.example.demu.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    USER_NOT_FOUND(404, "User Not Found"),
    PASSWORD_MISMATCH(401, "Password Mismatch"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),
    ACCOUNTID_ALREADY_EXISTS(409, "AccountId Already Exists"),

    POST_NOT_FOUND(404, "Post Not Found"),
    CANNOT_MODIFY_POST(403, "Cannot Modify Post"),

    COMMENT_NOT_FOUND(404, "Comment Not Found"),
    CANNOT_DELETE_COMMENT(403, "Not Delete Comment");

    private final int status;
    private final String message;
}
