package com.example.demu.domain.comment.controller;

import com.example.demu.domain.comment.controller.dto.CreateCommentRequest;
import com.example.demu.domain.comment.service.CreateCommentService;
import com.example.demu.domain.comment.service.DeleteCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/comment")
public class CommentController {

    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;

    @PostMapping("/create/{post-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable ("post-id") Long id, @RequestBody @Valid CreateCommentRequest request) {
        createCommentService.create(id, request);
    }

    @DeleteMapping("/delete/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable ("comment-id") Long id) {
        deleteCommentService.delete(id);
    }

}
