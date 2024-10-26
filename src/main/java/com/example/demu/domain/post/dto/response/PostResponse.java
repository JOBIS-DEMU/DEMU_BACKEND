package com.example.demu.domain.post.dto.response;

import com.example.demu.domain.comment.service.GetAllCommentService;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.user.domain.type.Grade;
import com.example.demu.domain.user.domain.type.Major;
import lombok.*;
import java.util.*;

@Getter
@AllArgsConstructor
public class PostResponse {

    private Long id;
    private String nickname;
    private String title;
    private String content;
    private Long recommend;
    private Grade grade;
    private Major major;
    private int commentCount;
    private List<String> images;

    public PostResponse (Post post, int count) {
        this.id = post.getId();
        this.nickname = post.getUser().getNickname();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.recommend = post.getRecommend();
        this.grade = post.getUser().getGrade();
        this.major = post.getMajor();
        this.commentCount = count;
        this.images = post.getImages();
    }

}