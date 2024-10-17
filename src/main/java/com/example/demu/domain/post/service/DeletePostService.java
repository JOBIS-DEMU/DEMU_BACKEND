package com.example.demu.domain.post.service;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional

public class DeletePostService {
    private final PostRepository postRepository;

    public void deletePost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        postRepository.delete(post);
    }

}
