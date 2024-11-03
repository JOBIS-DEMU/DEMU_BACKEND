package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.SignInRequest;
import com.example.demu.domain.auth.exception.PasswordMisMatchException;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.exception.UserNotFoundException;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtProvider;

    public TokenResponse signIn(SignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId()) .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtProvider.createAccessToken(request.getAccountId());
        String refreshToken = jwtProvider.createRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
