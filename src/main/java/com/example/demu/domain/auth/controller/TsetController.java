package com.example.demu.domain.auth.controller;


import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TsetController {

    @GetMapping("test")
    public String test() {
        return "test";
    }

}
