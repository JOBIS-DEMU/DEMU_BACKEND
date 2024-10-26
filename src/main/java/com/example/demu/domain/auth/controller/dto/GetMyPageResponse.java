package com.example.demu.domain.auth.controller.dto;

import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.type.Grade;
import com.example.demu.domain.user.domain.type.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetMyPageResponse {

    private String nickname;
    private Major major;
    private String intro;
    private Grade grade;
    private String profile;

    public GetMyPageResponse(User user) {
        this.nickname = user.getNickname();
        this.major = user.getMajor();
        this.intro = user.getIntro();
        this.grade = user.getGrade();
        this.profile = user.getProfile();
    }

}
