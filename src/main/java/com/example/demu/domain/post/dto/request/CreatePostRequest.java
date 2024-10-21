package com.example.demu.domain.post.dto.request;

import com.example.demu.domain.user.domain.type.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreatePostRequest {

    @Size(max = 25)
    private String title;

    @Size(max = 3000)
    private String content;

    private Major major;
}

