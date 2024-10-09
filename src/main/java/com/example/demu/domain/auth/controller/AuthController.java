package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final SignUpService signUpService;

    public TokenResponse SignUp(@Valid SignUpRequest signUpRequest) {
        return signUpService.execute(signUpRequest);
    }

}
