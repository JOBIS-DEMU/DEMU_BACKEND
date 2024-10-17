package com.example.demu.domain.post.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.post.exception.CannotModifyFeedException;
import com.example.demu.domain.post.facade.PostFacade;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.dto.request.UpdatePostRequest;
import com.example.demu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdatePostService {

    private final UserFacade userFacade;
    private final PostFacade postFacade;

    public void updatePost(Long id, UpdatePostRequest request){
        User user = userFacade.CurrentUser();
        Post post = postFacade.getPost(id);

        if(!user.equals(post.getUser())) {
            throw CannotModifyFeedException.EXCEPTION;
        }

        post.updatePost(request.getTitle(), request.getContent(), request.getMajor());
    }
}