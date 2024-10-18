package com.example.demu.domain.auth.service;

import com.example.demu.global.security.TokenResponse;
import com.example.demu.global.security.jwt.JwtReissueUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReissueSerivce {

    private final JwtReissueUtil jwtReissueUtil;

    @Transactional
    public TokenResponse reissue(String refreshToken) {
        return jwtReissueUtil.reissueAccessToken(refreshToken);
    }

}
