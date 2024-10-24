package com.example.demu.domain.user.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UpdateNicknameRequest {

    @NotBlank
    private String nickname;
}
