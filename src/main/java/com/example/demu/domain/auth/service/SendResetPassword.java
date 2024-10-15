package com.example.demu.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendResetPassword {

    @Autowired
    public SendResetPassword(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public JavaMailSender javaMailSender;


    public void SendResetPassword() {
     SimpleMailMessage message = new SimpleMailMessage();
     message.setTo("요청하신 비밀번호 변경페이지 입니다.");
     
    }

}
