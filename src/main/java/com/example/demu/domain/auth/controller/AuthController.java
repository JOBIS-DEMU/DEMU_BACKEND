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
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final FindPwService findPwService;
    private final UserFacade userFacade;
    private final ReissueService reissueService;
    private final ResetPasswordService resetPasswordService;
    private final JwtProperties jwtProperties;

    @PostMapping("/public/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse SignUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return signUpService.execute(signUpRequest);
    }

    @PostMapping("/public/signin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse signin(@RequestBody @Valid SignInRequest signInRequest) {
        return signInService.signIn(signInRequest);
    }


    @GetMapping("/password/validate")
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

    @PatchMapping("public/token/reissue")
    public TokenResponse reissue(HttpServletRequest request) {
        return reissueService.reissue(request);
    }


}
