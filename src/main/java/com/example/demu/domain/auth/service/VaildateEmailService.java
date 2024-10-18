package com.example.demu.domain.auth.service;

import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VaildateEmailService {
    private final UserRepository userRepository;

    public String vaildateEmail(String email) {
        if(userRepository.findByAccountId(email).isPresent()) {
            return "이메일로 전송했습니다.";
        }else{
            return "유효한 이메일이 아닙니다.";
        }
    }




}
