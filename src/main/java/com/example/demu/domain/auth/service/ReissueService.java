package com.example.demu.domain.auth.service;

import com.example.demu.global.security.TokenResponse;
import com.example.demu.global.security.jwt.JwtProperties;
import com.example.demu.global.security.jwt.JwtReissueUtil;
import com.example.demu.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JwtReissueUtil jwtReissueUtil;
    private final JwtProperties jwtProperties;
    private final JwtTokenProvider jwtProvider;

    @Transactional
    public TokenResponse reissue(HttpServletRequest request) {
        return jwtReissueUtil.reissue(jwtProvider.resolveToken(request));
    }

}
