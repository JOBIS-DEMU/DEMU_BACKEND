package com.example.demu.domain.auth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class UpdateNicknameRequest {

    @NotBlank
    private String nickname;
}
