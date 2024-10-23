package com.example.demu.global.security.jwt;

import com.example.demu.domain.auth.domain.RefreshToken;
import com.example.demu.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.demu.global.security.TokenResponse;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponse createToken(String accountId) {
         return TokenResponse.builder()
                .accessToken(createAccessToken(accountId))
                .refreshToken(createRefreshToken(accountId))
                .build();
    }

    public String createAccessToken(String accountId){
        Claims claims = Jwts.claims().setSubject(accountId);
        Date now = new Date();
                return Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setSubject(accountId)
                        .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                        .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExp()*1000))
                        .compact();
    }

    public String createRefreshToken(String accountId){
        Date now = new Date();

        String refreshToken = Jwts.builder()
                .setSubject(accountId)
                .claim("type","refresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+jwtProperties.getRefreshExp()*1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();

                refreshTokenRepository.save(
                        RefreshToken.builder()
                        .refreshToken(refreshToken)
                        .expiration(jwtProperties.getRefreshExp())
                        .accountId(accountId)
                        .build());

                return refreshToken;
    }


    public String resolveToken(HttpServletRequest request){

        String bearerToken = request.getHeader(jwtProperties.getHeader());


        if(bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())
        && bearerToken.length() > jwtProperties.getPrefix().length()){

            return bearerToken.substring(jwtProperties.getPrefix().length()).trim();
        }

        return null;
    }

    public Claims getbody(String token){
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).parseClaimsJws(token).getBody();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void ValidateToken(String token){
        Claims claims = getbody(token);
        if(claims.getExpiration().before(new Date())){
            throw new JwtException("Expired JWT token");
        }
    }
}
