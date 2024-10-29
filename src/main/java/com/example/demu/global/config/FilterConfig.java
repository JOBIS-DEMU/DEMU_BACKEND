package com.example.demu.global.config;


import com.example.demu.global.security.jwt.JwtFilter;
import com.example.demu.global.security.jwt.JwtProvider;
import com.example.demu.global.security.jwt.JwtReissueUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtProvider jwtTokenProvider;
    private final JwtReissueUtil jwtReissueUtil;

    @Override
    public void configure(HttpSecurity http) {

        JwtFilter jwtTokenFilter = new JwtFilter(jwtTokenProvider, jwtReissueUtil);

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }

}