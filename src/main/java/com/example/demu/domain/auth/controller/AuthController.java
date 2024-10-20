package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.service.SignInService;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.domain.auth.service.VaildateEmailService;
import com.example.demu.domain.auth.controller.dto.*;
import com.example.demu.domain.auth.service.*;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final FindPwService findPwService;
    private final UpdateMajorService updateMajorService;
    private final UpdateNicknameService updateNicknameService;
    private final UpdateIntroService updateIntroService;
    private final UpdateProfileImageService updateProfileImageService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse SignUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return signUpService.execute(signUpRequest);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse signin(@RequestBody @Valid SignInRequest signInRequest) {
        return signInService.signIn(signInRequest);
    }

    @GetMapping("password/find/{email}")
    public void vaildateEmail(@PathVariable String email) {
       findPwService.findPw(email);
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

    @PatchMapping("/profile-image")
    public void updateProfileImage(@RequestParam("images") MultipartFile image){
        updateProfileImageService.upDateProfile(image);
    }
}
