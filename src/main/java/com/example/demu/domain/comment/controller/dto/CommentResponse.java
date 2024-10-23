package com.example.demu.domain.comment.controller.dto;

import com.example.demu.domain.comment.domain.Comment;
import com.example.demu.domain.user.domain.type.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {

    private Long id;
    private String nickname;
    private String content;
    private Grade grade;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.nickname = comment.getUser().getNickname();
        this.content = comment.getContent();
        this.grade = comment.getUser().getGrade();
    }

}
