package com.example.demu.domain.auth.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class IntroReqeust {

    @Size(max = 20, message = "자기소개글은 20자 이내로 입력해야 합니다.")
    private String intro;
}
