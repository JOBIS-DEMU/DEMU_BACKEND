package com.example.demu.domain.comment.facade;

import com.example.demu.domain.comment.domain.Comment;
import com.example.demu.domain.comment.domain.repository.CommentRepository;
import com.example.demu.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

}
