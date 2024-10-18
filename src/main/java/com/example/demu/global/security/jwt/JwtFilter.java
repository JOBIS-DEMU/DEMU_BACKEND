package com.example.demu.global.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class JwtFilter extends OncePerRequestFilter {
private final JwtProvider jwtProvider;
private final JwtReissueUtil jwtReissueUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //헤더에서 jwt 받아와서 접두사 제거하기
        System.out.println("111111");

        String token = jwtProvider.resolveToken(request);
        System.out.println("222222");

        //헤더에 토큰이 있었는지
        if (token != null) {
            //jwt 만료되었는지 검증하기
            jwtProvider.ValidateToken(token);
            System.out.println("333333");
            //security context 에 추가하기
            Authentication authentication = jwtReissueUtil.getAuthentication(token);
            System.out.println("444444");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("555555");
        }
        filterChain.doFilter(request,response);
        System.out.println("6666666");
    }
}
