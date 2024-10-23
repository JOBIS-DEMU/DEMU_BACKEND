package com.example.demu.domain.post.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.comment.service.GetAllCommentService;
import com.example.demu.domain.post.domain.repository.PostRepository;
import com.example.demu.domain.post.dto.response.PostResponse;
import com.example.demu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUserAllPostsService {

    private final UserFacade userFacade;
    private final PostRepository postRepository;
    private final GetAllCommentService getAllCommentService;

    public List<PostResponse> getUserAllPosts() {
        User user = userFacade.CurrentUser();
        return postRepository.findAll()
                .stream()
                .filter(p -> p.getUser().getAccountId().equals(user.getAccountId()))
                .map(post -> {
                    return new PostResponse(post, getAllCommentService.countComment(post.getId()));
                })
                .toList();
    }

}
