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
    CANNOT_MODIFY_POST(403, "Cannot Modify Post"),
    EMPTY_FILE_EXCEPTION(400, "Empty File"),
    NO_FILE_EXTENTION(400, "No File Extension"),
    INVALID_FILE_EXTENTION(400, "Invalid File Extension"),

    //jwt 관련 에외
    ACCOUNTID_ALREADY_EXISTS(409, "Account ID Already Exists"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),

    // S3 업로드 관련 예외
    IO_EXCEPTION_ON_IMAGE_UPLOAD(500, "IO Exception on Image Upload"),
    PUT_OBJECT_EXCEPTION(500, "Failed to Upload Object to S3"),

    // S3 삭제 관련 예외
    IO_EXCEPTION_ON_IMAGE_DELETE(500, "IO Exception on Image Delete"),

    // 이미지 목록 조회 예외
    EXCEPTION_ON_LIST_IMAGES(500, "Failed to Retrieve Image List"),


    COMMENT_NOT_FOUND(404, "Comment Not Found"),
    CANNOT_DELETE_COMMENT(403, "Not Delete Comment");

    private final int status;
    private final String message;
}
