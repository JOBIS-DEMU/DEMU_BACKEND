package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.PasswordRequest;
import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.auth.service.SignInService;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.domain.auth.service.*;
import com.example.demu.global.security.TokenResponse;
import com.example.demu.global.security.jwt.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final FindPwService findPwService;
    private final UserFacade userFacade;
    private final ReissueService reissueService;
    private final ResetPasswordService resetPasswordService;

    @GetMapping
    public String test() {
        return "test";
    }

    @PostMapping("/aa")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse SignUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        System.out.println("1111111111111111111111111");
        return signUpService.execute(signUpRequest);

    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse signin(@RequestBody @Valid SignInRequest signInRequest) {
        return signInService.signIn(signInRequest);
    }


    @PostMapping("/validate")
    public void validatePassword(@RequestBody PasswordRequest passwordRequest) {
        userFacade.validatePassword(passwordRequest.getPassword());
    }

    @GetMapping("/public/password/find/{email}")
    public void vaildateEmail(@PathVariable String email) {
        findPwService.findPw(email);
    }

    @PatchMapping("/password/reset")
    public void resetPassword(@RequestBody @Valid PasswordRequest resetPasswordRequest) {
        resetPasswordService.resetPassword(resetPasswordRequest);
    }

    @PatchMapping("/token/reissue")
    public TokenResponse reissue(HttpServletRequest request) {
        return reissueService.reissue(request);
    }
}
