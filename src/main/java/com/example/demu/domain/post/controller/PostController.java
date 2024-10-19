package com.example.demu.domain.post.controller;

import com.example.demu.domain.post.dto.request.CreatePostRequest;
import com.example.demu.domain.post.dto.request.UpdatePostRequest;
import com.example.demu.domain.post.service.CreatePostService;
import com.example.demu.domain.post.service.DeletePostService;
import com.example.demu.domain.post.service.RecommendService;
import com.example.demu.domain.post.service.UpdatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final CreatePostService createPostService;
    private final DeletePostService deletePostService;
    private final UpdatePostService updatePostService;
    private final RecommendService recommendService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createPost(@RequestBody @Valid CreatePostRequest request, @RequestParam("images") List<MultipartFile> images){
        createPostService.createPost(request, images);
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

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{post-id}/recommend")
    public void addRecommend(@PathVariable("post-id") Long id) {
        recommendService.addRecommend(id);
    }

}