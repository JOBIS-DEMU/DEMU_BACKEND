package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.service.SignInService;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.domain.auth.service.*;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final FindPwService findPwService;
    private final ReissueService reissueService;


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

    @GetMapping("/public/password/find/{email}")
    public void vaildateEmail(@PathVariable String email) {
        findPwService.findPw(email);
    }

//    @PatchMapping("/profile-image")
//    public void updateProfileImage(@RequestParam("images") MultipartFile image){
//        updateProfileImageService.upDateProfile(image);
//    }

    @PatchMapping("/token")
    public TokenResponse reissue(String refreshToken) {
        return reissueService.reissue(refreshToken);
    }
}
