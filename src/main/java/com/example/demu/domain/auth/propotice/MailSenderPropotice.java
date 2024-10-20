package com.example.demu.domain.auth.propotice;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
public class MailSenderPropotice {
    /*@Value("${logging.mail.username}")
    private String userName;

    @Value("${logging.mail.port}")
    private String port;

    @Value("${logging.mail.password}")
    private String password;*/
}
