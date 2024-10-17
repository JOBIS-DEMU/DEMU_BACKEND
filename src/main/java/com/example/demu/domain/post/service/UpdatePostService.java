package com.example.demu.domain.post.service;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.domain.repository.PostRepository;
import com.example.demu.domain.post.dto.request.UpdatePostRequest;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional

public class UpdatePostService {
    private final PostRepository postRepository;

    public void updatePost(Long id, UpdatePostRequest request){
        Post post = postRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        post.updatePost(request.getTitle(), request.getContent(), request.getMajor());
    }
}