package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.IntroReqeust;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateIntroService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public void updateIntro(IntroReqeust reqeust) {
        User user = userFacade.CurrentUser();

        user.updateIntro(reqeust.getIntro());
        userRepository.save(user);
    }

}
