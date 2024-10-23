package com.example.demu.domain.auth.controller;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.controller.dto.SignUpRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.auth.service.SignInService;
import com.example.demu.domain.auth.service.SignUpService;
import com.example.demu.domain.auth.service.*;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.post.service.GetUserAllPostsService;
import com.example.demu.global.security.TokenResponse;
import com.example.demu.global.security.auth.AuthDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final UpdateProfileImageService updateProfileImageService;
    private final GetUserAllPostsService getUserAllPostsService;
    private final GetMyPageService getMyPageService;


    @PostMapping("public/signup")

    @PostMapping("/public/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse SignUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return signUpService.execute(signUpRequest);
    }

    @PostMapping("public/signin")
    @PostMapping("/public/signin")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse signin(@RequestBody @Valid SignInRequest signInRequest) {
        return signInService.signIn(signInRequest);
    }


    @GetMapping("/password/validate")
    public void validatePassword(@RequestBody PasswordRequest passwordRequest){
        userFacade.validatePassword(passwordRequest.getPassword());
    @GetMapping("/public/password/find/{email}")
    public void vaildateEmail(@PathVariable String email) {
        findPwService.findPw(email);
    }

    @PatchMapping("/password/reset")
    public void resetPassword(@RequestBody @Valid PasswordRequest resetPasswordRequest) {
        resetPasswordService.resetPassword(resetPasswordRequest);
    }
//    @PatchMapping("/profile-image")
//    public void updateProfileImage(@RequestParam("images") MultipartFile image){
//        updateProfileImageService.upDateProfile(image);
//    }

    @PatchMapping("/token")
    public TokenResponse reissue(String refreshToken) {
        return reissueService.reissue(refreshToken);
    }

    @PatchMapping("/nickname")
    @ResponseStatus(HttpStatus.OK)
    public void updateNickname(@RequestBody @Valid UpdateNicknameRequest request) {
        updateNicknameService.updateNickname(request);
    }

    @GetMapping("/my-page")
    @ResponseStatus(HttpStatus.OK)
    public GetMyPageResponse getMyPage() {
        return getMyPageService.getMyPage();
    }

    @PatchMapping("/profile-image")
    public void updateProfileImage(@RequestParam("images") MultipartFile image){
        updateProfileImageService.upDateProfile(image);
    }
}
