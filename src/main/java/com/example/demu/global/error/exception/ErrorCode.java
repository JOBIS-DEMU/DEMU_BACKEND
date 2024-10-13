package com.example.demu.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    USER_NOT_FOUND(404, "User Not Found"),
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    EMPTY_FILE_EXCEPTION(400,"File is empty or filename is missing"),
    IO_EXCEPTION_ON_IMAGE_UPLOAD(500,"IO Exception occurred during image upload"),

    NO_FILE_EXTENTION(400,"File is not exist"),
    INVALID_FILE_EXTENTION(400, "File is invalid"),
    PUT_OBJECT_EXCEPTION(500,"Server can't up load image"),
    EXCEPTION_ON_LIST_IMAGES(500,"Can't load image"),

    IO_EXCEPTION_ON_IMAGE_DELETE(400,"Can't delete image");

    private final int status;
    private final String message;
}
