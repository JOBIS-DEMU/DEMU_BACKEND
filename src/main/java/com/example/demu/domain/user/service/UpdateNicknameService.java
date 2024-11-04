package com.example.demu.domain.user.service;

import com.example.demu.domain.user.controller.dto.UpdateNicknameRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateNicknameService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void updateNickname(UpdateNicknameRequest request) {
        User user = userFacade.CurrentUser();
        userFacade.CheckByNickname(request.getNickname());

        user.updateNickname(request.getNickname());
    }

}
