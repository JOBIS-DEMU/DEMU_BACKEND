package com.example.demu.domain.post.facade;

import com.example.demu.domain.user.domain.type.Major;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MajorFacade {

    public Major[] values(){
        return Major.values();
    }

    //방법1 : 대소문자 구분있음(무조건 enum 클래스이름(대문자)로만 해야함)
    public Major findByName2(String name) {
        return Major.valueOf(name);
    }

    //방법2 : 대소문자 구분없음
    public Major findByName(String name){
        return Arrays.stream(values())
                .filter(Major -> Major.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

}
