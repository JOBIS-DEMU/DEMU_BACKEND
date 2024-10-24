package com.example.demu.domain.user.service;

import com.example.demu.domain.user.controller.dto.IntroReqeust;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateIntroService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public void updateIntro(IntroReqeust reqeust) {
        User user = userFacade.CurrentUser();

        user.updateIntro(reqeust.getIntro());
        userRepository.save(user);
    }

}
