package com.example.demu.domain.auth.facade;

import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class UserFacade {
    public final UserRepository userRepository;

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
}

