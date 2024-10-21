package com.example.demu.domain.auth.facade;

import com.example.demu.domain.auth.controller.dto.PasswordRequest;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class UserFacade {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public void CheckByaccountId(String accountId) {
        if(userRepository.findByAccountId(accountId).isPresent()){
            throw new RuntimeException("User already exists");
        }
    }

    public User CurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void validatePassword(User user,String currentPassword){
        System.out.println("현재비번 :"+user.getPassword());
        System.out.println("입력값 비번 : "+currentPassword);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        if(!(passwordEncoder.matches(SecurityContextHolder.getContext().getAuthentication().getCredentials().toString(), currentPassword))){
            throw new RuntimeException("Invalid password");
        }
    }

}

