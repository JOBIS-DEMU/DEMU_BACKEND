package com.example.demu.domain.post.dto.response;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.user.domain.type.Grade;
import lombok.*;

@Getter
@AllArgsConstructor
public class PostResponse {

    private Long id;
    private String nickname;
    private String title;
    private String content;
    private Long recommend;
    private Grade grade;

    public PostResponse (Post post) {
        this.id = post.getId();
        this.nickname = post.getUser().getNickname();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.recommend = post.getRecommend();
        this.grade = post.getUser().getGrade();
    }
}