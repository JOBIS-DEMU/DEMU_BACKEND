package com.example.demu.domain.auth.facade;

import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
    public UserRepository userRepository;


    public void CheckByaccountId(String accountId) {
        if(userRepository.findByAccountId(accountId).isPresent()){
            throw new RuntimeException("User already exists");
        }
    }

}
