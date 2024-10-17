package com.example.demu.domain.post.dto.response;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponse {

    private Long id;
    private String accountId;
    private String title;
    private String content;
    private String date;
    private String recommend;
    private String major;
}