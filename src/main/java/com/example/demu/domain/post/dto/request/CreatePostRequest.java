package com.example.demu.domain.post.dto.request;

import com.example.demu.domain.user.domain.type.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePostRequest {

    private String title;
    private String content;
    private Major major;
}

