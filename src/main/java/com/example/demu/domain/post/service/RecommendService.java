package com.example.demu.domain.post.service;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.domain.repository.PostRepository;
import com.example.demu.domain.post.exception.PostNotfoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RecommendService {

    private final PostRepository postRepository;

    @Transactional
    public void addRecommend(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotfoundException.EXCEPTION);

        post.addRecommend();
        post.getUser().plusPoint();
    }

}
