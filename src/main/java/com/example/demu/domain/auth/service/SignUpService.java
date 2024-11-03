package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.exception.NicknameAlreadyExistsException;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.domain.user.domain.type.Grade;
import com.example.demu.domain.user.domain.type.Major;
import com.example.demu.global.security.TokenResponse;
import com.example.demu.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignUpService {

    private JwtProvider jwtTokenProvider;
    private UserFacade userFacade;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpService(JwtProvider jwtTokenProvider, UserFacade userFacade, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userFacade = userFacade;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public TokenResponse execute(SignUpRequest signUpRequest) {
        if(signUpRequest.getNickname().equals("aaaa")){
            throw NicknameAlreadyExistsException.EXCEPTION;
        }

        userFacade.CheckByaccountId(signUpRequest.getAccountId());
        userFacade.CheckBynickname(signUpRequest.getNickname());
        System.out.println("222222222222222222222");

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
        System.out.println("3333333333333333333333333333333333333333");

        return jwtTokenProvider.createToken(signUpRequest.getAccountId());
    }
}
