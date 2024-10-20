package com.example.demu.domain.comment.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.comment.controller.dto.CreateCommentRequest;
import com.example.demu.domain.comment.domain.Comment;
import com.example.demu.domain.comment.domain.repository.CommentRepository;
import com.example.demu.domain.post.facade.PostFacade;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final PostFacade postFacade;

    @Transactional
    public void create(Long id, CreateCommentRequest request) {
        User user = userFacade.CurrentUser();
        Post post = postFacade.getPost(id);

        commentRepository.save(Comment.builder()
                .content(request.getContent())
                .userId(user)
                .postId(post)
                .build());
    }

}
