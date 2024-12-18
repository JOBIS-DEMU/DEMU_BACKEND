package com.example.demu.global.security.jwt;

import com.example.demu.global.exception.JwtSigningException;
import com.example.demu.global.security.TokenResponse;
import com.example.demu.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtReissueUtil {
    public final JwtProperties jwtProperties;
    public final JwtProvider jwtProvider;
    public final AuthDetailsService authDetailSerivce;

    //엑세스 토큰 재발행
    //파라미터로 들어오는 refreshToken은 파싱되지 않은 token
    public TokenResponse reissueAccessToken(String refreshToken) {
        //리프레시 토큰인지 확인
        if(!(isRefreshToken(refreshToken))){
            throw new JwtException("is not refreshToken");
        }

        String accountId = getTokenAccountId(refreshToken);

            return TokenResponse.builder()
                    .accessToken(jwtProvider.createAccessToken(accountId))
                    .refreshToken(refreshToken)
                    .build();
    }


    //토큰파싱하고 페이로드부분 돌려주기
    public Claims getPayload(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            throw new JwtSigningException();
        }

    }

    //클래임 받아서 리프레시 토큰인지 확인
    public boolean isRefreshToken(String refreshToken) {
        return getPayload(refreshToken).get("type").equals("refresh");
    }

    public String getTokenAccountId(String token) {
        return getPayload(token).getSubject();
    }


    public Authentication getAuthentication(String token) {
        Claims claims = getPayload(token);
        UserDetails userDetails = authDetailSerivce.loadUserByUsername(claims.getSubject());
        System.out.println("accountId : "+claims.getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }


}
