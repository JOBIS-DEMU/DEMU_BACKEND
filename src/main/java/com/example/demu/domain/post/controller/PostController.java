package com.example.demu.domain.post.controller;

import com.example.demu.domain.post.dto.request.CreatePostRequest;
import com.example.demu.domain.post.dto.request.UpdatePostRequest;
import com.example.demu.domain.post.service.CreatePostService;
import com.example.demu.domain.post.service.DeletePostService;
import com.example.demu.domain.post.service.UpdatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final CreatePostService createPostService;
    private final DeletePostService deletePostService;
    private final UpdatePostService updatePostService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createPost(@RequestBody @Valid CreatePostRequest request){
        createPostService.createPost(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{post-id}")
    public void deletePost(@PathVariable("post-id") Long id){
        deletePostService.deletePost(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update/{post-id}")
    public void updatePost(@PathVariable("post-id") Long id, @RequestBody @Valid UpdatePostRequest request){
        updatePostService.updatePost(id, request);
    }
}