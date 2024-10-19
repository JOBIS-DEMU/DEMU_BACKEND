package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.FindPwResponse;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FindPwService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private MailSender mailSender;

    @Autowired
    public FindPwService(UserRepository userRepository, PasswordEncoder passwordEncoder, MailSender mailSender) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
    }



    public void findPw(String email) {

        //user 의 accountId 가 dms eamil임으로 만약 찾지 못하면, 회원가입한 이메일이 아닌것임.
        User user = userRepository.findByAccountId(email).orElseThrow(() -> new RuntimeException("User not found"));


        // 임시비밀번호 생성
        char[] charSet = new char[] {
                '0','1','2','3','4','5','6','7','8','9',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
        };

        StringBuilder tempPw = new StringBuilder();

        for(int i=0 ; i<charSet.length ; i++) {
            int idx;
            idx = (int)(charSet.length*Math.random());
            tempPw.append(charSet[idx]);
        }


        FindPwResponse findPwResponse = FindPwResponse.builder()
                .title("요청하신 임시비밀번호입니다!")
                .content("보")
                .receivedAddress(email)
                .build();

    }


}
