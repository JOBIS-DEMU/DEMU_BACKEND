package com.example.demu.domain.comment.service;

import com.example.demu.domain.comment.controller.dto.CommentResponse;
import com.example.demu.domain.comment.domain.repository.CommentRepository;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.facade.PostFacade;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class GetAllCommentService {

    private final CommentRepository commentRepository;
    private final PostFacade postFacade;

    @Transactional(readOnly = true)
    public List<CommentResponse> getAllComment(Long id) {
        Post post = postFacade.getPost(id);
        return commentRepository.findAll()
                .stream()
                .filter(c -> c.getPost().getId().equals(post.getId()))
                .map(CommentResponse::new)
                .toList();
    }

    public int countComment(Long id) {
        List<CommentResponse> cnt = getAllComment(id);
        return cnt.size();
    }

}
