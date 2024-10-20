package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.service.*;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final ReissueSerivce reissueSerivce;
    private final FindPwService findPwService;
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

    @PostMapping("/token")
    public TokenResponse reissue(String refreshToken) {
        return reissueSerivce.reissue(refreshToken);
    }

    @GetMapping("password/find/{email}")
    public void vaildateEmail(@PathVariable String email) {
        findPwService.findPw(email);
    }

    @PatchMapping("/profile-image")
    public void updateProfileImage(@RequestParam("images") MultipartFile image){
        updateProfileImageService.upDateProfile(image);
    }
}
