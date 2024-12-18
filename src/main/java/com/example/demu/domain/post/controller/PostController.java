package com.example.demu.domain.post.controller;

import com.example.demu.domain.post.dto.request.CreatePostRequest;
import com.example.demu.domain.post.dto.request.UpdatePostRequest;
import com.example.demu.domain.post.dto.response.PostResponse;
import com.example.demu.domain.post.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.Valid;


@RequestMapping("/post")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final CreatePostService createPostService;
    private final DeletePostService deletePostService;
    private final UpdatePostService updatePostService;
    private final RecommendService recommendService;
    private final GetPostService getPostService;
    private final GetUserAllPostsService getUserAllPostsService;
    private final GradePercentService gradePercentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createPost(@RequestPart("post") @Valid CreatePostRequest request,@RequestPart("iamges") List<MultipartFile> images){
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
    @PostMapping("/recommend/{post-id}")
    public void addRecommend(@PathVariable("post-id") Long id) {
        recommendService.addRecommend(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/{post-id}")
    public PostResponse getPost(@PathVariable("post-id") Long postId){
        return getPostService.getPost(postId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/my-posts")
    public List<PostResponse> getAllUserPost(){
        return getUserAllPostsService.getUserAllPosts();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/grade")
    public double getPercent() {
        return gradePercentService.getPercent();
    }

}