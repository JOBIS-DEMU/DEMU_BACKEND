package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.ChangeUserIdRequest;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeUserIdService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void changeUserId() {

        userFacade.getCurrentUser();

        //return "test";
       // User user = userRepository.findByAccountId(request.getAccountId())
             //   .orElseThrow(() -> new UserNotFoundException.EXCEPTION;
    }
}
