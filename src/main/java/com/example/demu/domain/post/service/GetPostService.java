package com.example.demu.domain.post.service;

import com.example.demu.domain.comment.service.GetAllCommentService;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.dto.response.PostResponse;
import com.example.demu.domain.post.facade.PostFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetPostService {

    private final PostFacade postFacade;
    private final GetAllCommentService getAllCommentService;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postFacade.getPost(id);
        return new PostResponse(post, getAllCommentService.countComment(post.getId()));
    }
}
