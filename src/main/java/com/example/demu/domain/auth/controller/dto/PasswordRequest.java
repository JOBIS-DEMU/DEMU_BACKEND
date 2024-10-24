package com.example.demu.domain.auth.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class PasswordRequest {
    @NotBlank
    private String password;

}
