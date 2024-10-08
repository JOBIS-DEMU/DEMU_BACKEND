package com.example.demu.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//csrf 보호 비활성화
                .cors()
                .and()
                .exceptionHandling()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//jwt 방식이니 세션 저장안하기
                .and()
                .authorizeRequests()
                    .antMatchers("/api/public/**").permitAll() // (api/pulic/ 으로 시작하는 url 은 로그인 없이도 사용 가능)
                .anyRequest().authenticated(); // 나머진 인증 필요
    }


}
