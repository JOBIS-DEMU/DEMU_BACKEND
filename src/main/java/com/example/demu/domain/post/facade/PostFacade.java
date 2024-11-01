package com.example.demu.domain.post.facade;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.domain.repository.PostRepository;
import com.example.demu.domain.post.exception.PostNotfoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFacade {

    private final PostRepository postRepository;

    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> PostNotfoundException.EXCEPTION);
    }
}
