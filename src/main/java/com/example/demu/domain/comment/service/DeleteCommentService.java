package com.example.demu.domain.comment.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.comment.domain.Comment;
import com.example.demu.domain.comment.domain.repository.CommentRepository;
import com.example.demu.domain.comment.exception.NotDeleteCommentException;
import com.example.demu.domain.comment.facade.CommentFacade;
import com.example.demu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    @Transactional
    public void delete(Long id) {

        User user = userFacade.CurrentUser();
        Comment comment = commentFacade.getComment(id);

        if(!user.equals(comment.getUser())) {
            throw NotDeleteCommentException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }
}
