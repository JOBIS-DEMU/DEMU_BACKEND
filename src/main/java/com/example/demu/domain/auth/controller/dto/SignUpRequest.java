package com.example.demu.domain.auth.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Getter
public class SignUpRequest {

    @NotBlank(message = "accountId 는 null 이거나 공백, 뛰어쓰기를 허용하지 않습니다.")//이메일
    @Size(max = 30,message = "accountId 30글자 이하여야 합니다.")
    @Email
    private String accountId;

    @NotEmpty(message = "nickname 는 null 이거나 공백을 허용하지 않습니다.")
    @Size(min = 3, max = 10,message = "nickname 는 2글자 이상 10글자 이하여야 합니다.")
    private String nickname;

    @NotBlank(message = "password 는 null 이거나 공백, 뛰어쓰기를 허용하지 않습니다.")
    @Size(min = 8, max = 20,message = "password 는 8글자 이상 20글자 이하여야 합니다.")
    private String password;
}
