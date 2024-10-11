package com.example.demu.global.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
private final JwtProvider jwtProvider;
private final JwtReissueUtil jwtReissueUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //헤더에서 jwt 받아와서 접두사 제거하기
        String token = jwtProvider.resolveToken(request);
        //헤더에 토큰이 있었는지
        if (token != null) {
            //jwt 만료되었는지 검증하기
            jwtProvider.ValidateToken(token);
            //security context 에 추가하기
            Authentication authentication = jwtReissueUtil.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }
}
