package com.example.demu.domain.post.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.domain.repository.PostRepository;
import com.example.demu.domain.post.exception.CannotModifyPostException;
import com.example.demu.domain.post.facade.PostFacade;
import com.example.demu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class DeletePostService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;
    private final PostFacade postFacade;
    //private final S3ImageService s3ImageService;

    public void deletePost(Long id){
        User user = userFacade.CurrentUser();
        Post post = postFacade.getPost(id);

        //List<String> images = post.getImageLinks();


     //   images.forEach(s3ImageService::deleteImageFromS3);

        if(!user.equals(post.getUser())) {
            throw CannotModifyPostException.EXCEPTION;
        }

        postRepository.delete(post);
    }

}
