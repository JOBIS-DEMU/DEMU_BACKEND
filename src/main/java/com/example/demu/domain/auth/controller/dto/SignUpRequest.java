package com.example.demu.domain.auth.controller.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SignUpRequest {

    @NotBlank(message = "accountId 는 null 이거나 공백, 뛰어쓰기를 허용하지 않습니다.")
    @Size(min = 3, max = 20,message = "accountId 는 3글자 이상 20글자 이하여야 합니다.")
    private String accountId;

    @NotEmpty(message = "nickname 는 null 이거나 공백을 허용하지 않습니다.")
    @Size(min = 3, max = 10,message = "nickname 는 3글자 이상 20글자 이하여야 합니다.")
    private String nickname;

    @NotBlank(message = "password 는 null 이거나 공백, 뛰어쓰기를 허용하지 않습니다.")
    @Size(min = 5, max = 20,message = "password 는 5글자 이상 20글자 이하여야 합니다.")
    private String password;
}
