package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
import com.example.demu.infra.service.S3ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UpdateProfileImageService {
    private final UserRepository userRepository;
    private final S3ImageService s3ImageService;
    private final UserFacade userFacade;
    public void upDateProfile(MultipartFile image){
        User user = userFacade.CurrentUser();
        String imageLink = s3ImageService.upload(image);
        user.updateprofileImage(imageLink);
        userRepository.save(user);
    }
}
