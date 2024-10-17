package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.service.SignInService;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse signup(@Valid SignUpRequest signUpRequest) {
        return signUpService.execute(signUpRequest);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse signin(@Valid SignInRequest signInRequest) {
        return signInService.signIn(signInRequest);
    }
}
