package com.example.demu.domain.post.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.domain.repository.PostRepository;
import com.example.demu.domain.post.dto.request.CreatePostRequest;
import com.example.demu.domain.user.domain.User;
import com.example.demu.infra.service.S3ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreatePostService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;
    private final S3ImageService s3ImageService;

    public void createPost(CreatePostRequest request, List<MultipartFile> images) {

        User user = userFacade.CurrentUser();

        List<String> imagesToString = images.stream().map(s3ImageService::upload).toList();

        postRepository.save(Post.builder()
                .user(user)
                .title(request.getTitle())
                .content(request.getContent())
                .date(LocalDateTime.now())
                .recommend(0L)
                .images(imagesToString)
                .build());
    }
}
