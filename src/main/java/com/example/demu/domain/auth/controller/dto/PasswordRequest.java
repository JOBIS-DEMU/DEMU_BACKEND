package com.example.demu.domain.auth.controller.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class PasswordRequest {

    private String password;

}
