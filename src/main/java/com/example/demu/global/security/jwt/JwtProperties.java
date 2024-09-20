package com.example.demu.global.security.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class JwtProperties {
    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.prefix}")
    private String prefix;

    @Value("${jwt.access_exp}")
    private long accessExp;

    @Value("${jwt.refresh_exp}")
    private long refreshExp;

    @Value("${jwt.secret_key}")
    private String secretKey;
}
