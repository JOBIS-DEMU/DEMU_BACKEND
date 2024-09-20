package com.example.demu.global.security;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponse {

    private String accessToken;

    private String refreshToken;
}
