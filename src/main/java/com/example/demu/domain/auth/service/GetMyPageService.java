package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.controller.dto.GetMyPageResponse;
import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMyPageService {

    private final UserFacade userFacade;

    public GetMyPageResponse getMyPage() {
        User user = userFacade.CurrentUser();
        return new GetMyPageResponse(user);
    }

}