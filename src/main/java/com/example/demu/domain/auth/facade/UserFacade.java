package com.example.demu.domain.auth.facade;

import com.example.demu.domain.auth.controller.dto.PasswordRequest;
import com.example.demu.domain.auth.exception.AccountIdAlreadyExistsException;
import com.example.demu.domain.auth.exception.NicknameAlreadyExistsException;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFacade {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public void CheckByaccountId(String accountId) {
        if(userRepository.findByAccountId(accountId).isPresent()){
            throw AccountIdAlreadyExistsException.EXCEPTION;
        }
    }

    public void CheckBynickname(String nickname) {
        if(userRepository.findByNickname(nickname).isPresent()){
            throw NicknameAlreadyExistsException.EXCEPTION;
        }
    }


    public User CurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void validatePassword(String currentPassword){
        User user = CurrentUser();

        System.out.println("현재비번 :"+user.getPassword());
        System.out.println("입력값 비번 : "+currentPassword);



        if(!(passwordEncoder.matches(currentPassword,user.getPassword()))){
            throw new RuntimeException("Invalid password");
        }
    }

}

