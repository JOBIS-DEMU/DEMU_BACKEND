package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.service.ReissueSerivce;
import com.example.demu.domain.auth.service.SignInService;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.domain.auth.service.VaildateEmailService;
import com.example.demu.domain.auth.controller.dto.*;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.user.service.UpdateIntroService;
import com.example.demu.domain.user.service.UpdateMajorService;
import com.example.demu.domain.user.service.UpdateNicknameService;
import com.example.demu.domain.user.service.UserPostListServce;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final ReissueSerivce reissueSerivce;

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
}
