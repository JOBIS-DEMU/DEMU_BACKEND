package com.example.demu.domain.user.controller;

import com.example.demu.domain.user.controller.dto.IntroReqeust;
import com.example.demu.domain.user.controller.dto.UpdateMajorRequest;
import com.example.demu.domain.user.controller.dto.UpdateNicknameRequest;
import com.example.demu.domain.user.service.UpdateIntroService;
import com.example.demu.domain.user.service.UpdateMajorService;
import com.example.demu.domain.user.service.UpdateNicknameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UpdateIntroService updateIntroService;
    private final UpdateMajorService updateMajorService;
    private final UpdateNicknameService updateNicknameService;

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