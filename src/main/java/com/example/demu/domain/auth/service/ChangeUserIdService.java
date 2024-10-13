package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.ChangeUserIdRequest;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.exception.UserNotFoundException;
import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeUserIdService {

    private final UserRepository userRepository;

    public void changeUserId(ChangeUserIdRequest request) {
        //User user = userRepository.findByAccountId(request.getAccountId())
        //        .orElseThrow(() -> new UserNotFoundException.EXCEPTION;
    }
}
