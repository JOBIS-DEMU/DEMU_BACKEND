package com.example.demu.domain.auth.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@RedisHash
public class RefreshToken {
    @Id
    private String accountId;

    private String refreshToken;

    @TimeToLive
    private Long expiration;

}
