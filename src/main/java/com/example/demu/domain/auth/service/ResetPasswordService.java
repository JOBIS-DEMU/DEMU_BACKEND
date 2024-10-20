package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.PasswordRequest;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ResetPasswordService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Transactional
    public void resetPassword(User user, PasswordRequest request) {

        user.updatePassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

    }
}
