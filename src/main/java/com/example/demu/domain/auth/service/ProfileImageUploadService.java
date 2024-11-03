package com.example.demu.domain.auth.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.repository.UserRepository;
//import com.example.demu.infra.service.S3ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileImageUploadService {
    //private final S3ImageService s3ImageService;
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    public void execute(MultipartFile image){
        User user = userFacade.CurrentUser();
       // user.updateProfile(s3ImageService.upload(image));
        userRepository.save(user);
    }
}
