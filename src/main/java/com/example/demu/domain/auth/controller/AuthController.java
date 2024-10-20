package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.auth.service.SignInService;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.domain.auth.controller.dto.*;
import com.example.demu.domain.auth.service.*;
import com.example.demu.domain.user.domain.User;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final FindPwService findPwService;
    private final UpdateMajorService updateMajorService;
    private final UpdateNicknameService updateNicknameService;
    private final UpdateIntroService updateIntroService;
    private final ResetPasswordService resetPassword;
    private final ResetPasswordService resetPasswordService;
    private final UserFacade userFacade;


    @PostMapping("public/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse SignUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return signUpService.execute(signUpRequest);
    }

    @PostMapping("public/signin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse signin(@RequestBody @Valid SignInRequest signInRequest) {
        return signInService.signIn(signInRequest);
    }


    @GetMapping("/password/vaildate")
    public void validatePassowd(@AuthenticationPrincipal User user, PasswordRequest passwordRequest){
        userFacade.validatePassword(user, passwordRequest.getPassword());
    }


    @PatchMapping("/password/reset")
    public void resetPassword(@AuthenticationPrincipal User user, @RequestBody @Valid PasswordRequest resetPasswordRequest) {
        resetPasswordService.resetPassword(user,resetPasswordRequest);
    }


    @PatchMapping("/intro")
    @ResponseStatus(HttpStatus.OK)
    public void updateIntro(@RequestBody @Valid IntroReqeust reqeust) {
        updateIntroService.updateIntro(reqeust);
    }

    @PatchMapping("/major")
    @ResponseStatus(HttpStatus.OK)
    public void updateMajor(@RequestBody UpdateMajorRequest request) {
        updateMajorService.updateMajor(request);
    }

    @PatchMapping("/nickname")
    @ResponseStatus(HttpStatus.OK)
    public void updateNickname(@RequestBody @Valid UpdateNicknameRequest request) {
        updateNicknameService.updateNickname(request);
    }


}
