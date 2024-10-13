package com.example.demu.global.security.exception.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GolbalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        //해쉬맵 만들기
        Map<String, String> errors = new HashMap<>();
        //예외에 대한 전체정보 받아오기,목록화하기,forEach 로 순회하기
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            //HashMap 에 저장
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
