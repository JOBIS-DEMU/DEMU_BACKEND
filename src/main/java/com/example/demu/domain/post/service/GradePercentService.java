package com.example.demu.domain.post.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
 public class GradePercentService {

    private final UserFacade userFacade;

    public double getPercent() {

        User user = userFacade.CurrentUser();
        if(user.getPoint() < 70){
            return ((double) (user.getPoint()-user.getGrade().getPoint()) / user.getGrade().getNextPointLength()) * 100;
        } else{
            return 100.0;
        }
    }
}