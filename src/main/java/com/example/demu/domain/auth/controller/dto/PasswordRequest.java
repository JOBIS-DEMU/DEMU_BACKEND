package com.example.demu.domain.auth.controller.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class PasswordRequest {

    @NotBlank(message = "password 는 null 이거나 공백, 뛰어쓰기를 허용하지 않습니다.")
    @Size(min = 8, max = 20,message = "password 는 8글자 이상 20글자 이하여야 합니다.")
    private String Password;

}
