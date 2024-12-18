package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.exception.AccountIdAlreadyExistsException;
import com.example.demu.domain.auth.exception.NicknameAlreadyExistsException;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.domain.user.domain.type.Grade;
import com.example.demu.domain.user.domain.type.Major;
import com.example.demu.global.security.TokenResponse;
import com.example.demu.global.security.jwt.JwtProvider;
import com.example.demu.global.security.jwt.JwtReissueUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class SignUpService {

    private final JwtReissueUtil jwtReissueUtil;
    private final JwtProvider jwtProvider;
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(SignUpRequest signUpRequest) {
        if(signUpRequest.getNickname().equals("aaaa")){
            throw NicknameAlreadyExistsException.EXCEPTION;
        }

    userFacade.CheckByaccountId(signUpRequest.getAccountId());
    userFacade.CheckBynickname(signUpRequest.getNickname());


    userRepository.save(
            User.builder()
                    .accountId(signUpRequest.getAccountId())
                    .nickname(signUpRequest.getNickname())
                    .password(passwordEncoder.encode(signUpRequest.getPassword()))
                    .grade(Grade.BRONZE)
                    .major(Major.NONE)
                    .point(0)
                    .build()
    );

    return jwtProvider.createToken(signUpRequest.getAccountId());
    }
}
