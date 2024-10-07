package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.global.security.TokenResponse;
import com.example.demu.global.security.jwt.JwtProvider;
import com.example.demu.global.security.jwt.JwtReissueUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final JwtReissueUtil jwtReissueUtil;
    private final JwtProvider jwtProvider;
    private final UserFacade userFacade;



public TokenResponse execute(SignUpRequest signUpRequest) {
    //최초 유저 생성시 비활성화 해야함 (nullPointerException 뜸)
    userFacade.CheckByaccountId(signUpRequest.getAccountId());

    User user = User.builder()
            .accountId(signUpRequest.getAccountId())
            .nickname(signUpRequest.getNickname())
            .password(signUpRequest.getPassword())
            .build();

    return jwtProvider.createToken(signUpRequest.getAccountId());
    }


}
