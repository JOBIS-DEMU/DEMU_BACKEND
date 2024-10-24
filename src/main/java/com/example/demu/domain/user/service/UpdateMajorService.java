package com.example.demu.domain.user.service;

import com.example.demu.domain.user.controller.dto.UpdateMajorRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateMajorService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void updateMajor(UpdateMajorRequest request) {
        User user = userFacade.CurrentUser();

        user.updateMajor(request.getMajor());
        userRepository.save(user);
    }

}
