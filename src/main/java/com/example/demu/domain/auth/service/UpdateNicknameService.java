package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.UpdateNicknameRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateNicknameService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void updateNickname(UpdateNicknameRequest request) {
        User user = userFacade.CurrentUser();

        user.updateNickname(request.getNickname());
        userRepository.save(user);
    }
}
