package com.example.demu.domain.auth.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@Getter
@Setter
public class SignInRequest {

    @NotBlank
    @JsonProperty("accountId") // JSON 키와 매핑 보장
    private String accountId;

    @NotBlank
    private String password;

}
