package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.PasswordRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.global.security.auth.AuthDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ResetPasswordService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserFacade userFacade;


    @Transactional
    public void resetPassword(PasswordRequest request) {

        User currentUser = userFacade.CurrentUser();

        currentUser.updatePassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(currentUser);

    }
}
