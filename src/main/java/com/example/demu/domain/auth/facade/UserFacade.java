package com.example.demu.domain.auth.facade;

import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.domain.user.exception.AccountIdAlreadyExistsException;
import com.example.demu.domain.user.exception.NicknameAlreadyExistsException;
import com.example.demu.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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

    public User CurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void validatePassword(String currentPassword){
        User user = CurrentUser();

        if(!(passwordEncoder.matches(currentPassword,user.getPassword()))){
            throw new RuntimeException("Invalid password");
        }
    }

    public void CheckByNickname(String nickname) {
        if(userRepository.findByNickname(nickname).isPresent()) {
            throw NicknameAlreadyExistsException.EXCEPTION;
        }
    }
}

