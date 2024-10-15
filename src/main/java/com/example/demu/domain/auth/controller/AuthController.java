package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.service.ChangeUserIdService;
import com.example.demu.domain.auth.service.SignInService;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.domain.auth.service.VaildateEmailService;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final VaildateEmailService vaildateEmailService;
    private final ChangeUserIdService changeUserIdService;;

    @PostMapping("signup")
    public TokenResponse SignUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return signUpService.execute(signUpRequest);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse signin(@RequestBody @Valid SignInRequest signInRequest) {
        return signInService.signIn(signInRequest);
    }

    @PostMapping("/vaildate/email")
    public String vaildateEmail(@RequestParam String email) {
       return vaildateEmailService.vaildateEmail(email);
    }



/*
    @PostMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String tset() {
        return changeUserIdService.changeUserId();
    }*/
}
