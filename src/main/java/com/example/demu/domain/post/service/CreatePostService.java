package com.example.demu.domain.post.service;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.domain.repository.PostRepository;
import com.example.demu.domain.post.dto.request.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional

public class CreatePostService {

    private final PostRepository postRepository;

    public void createPost(CreatePostRequest request) {
        postRepository.save(Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .major(request.getMajor())
                .date(LocalDateTime.now())
                .recommend(0L)
                .build());
    }

}