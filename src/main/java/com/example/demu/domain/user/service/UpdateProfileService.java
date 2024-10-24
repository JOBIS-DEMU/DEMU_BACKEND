package com.example.demu.domain.user.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.infra.service.S3ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UpdateProfileService {
    private final UserRepository userRepository;
    private final S3ImageService s3ImageService;
    private final UserFacade userFacade;
    @Transactional
    public void excute(MultipartFile image){
        User user = userFacade.CurrentUser();

        user.updateProfile(s3ImageService.upload(image));
    }
}
