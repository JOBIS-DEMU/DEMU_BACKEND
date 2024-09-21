package com.example.demu.global.security.exception;

public class JwtSigningException extends RuntimeException{

    public JwtSigningException(){
    }

    public JwtSigningException(String message){
        super(message);
    }
}
