package com.example.demu.domain.post.service;

import com.example.demu.domain.auth.facade.UserFacade;
import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.domain.repository.PostRepository;
import com.example.demu.domain.post.dto.request.CreatePostRequest;
import com.example.demu.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class CreatePostService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;
 //   private final S3ImageService s3ImageService;

    public void createPost(CreatePostRequest request) {

        User user = userFacade.CurrentUser();
       /* List<String> imageLinks = new ArrayList<>();
        for(MultipartFile image: images){
            imageLinks.add(s3ImageService.upload(image));
        }
*/

        postRepository.save(Post.builder()
                .user(user)
                .title(request.getTitle())
                .content(request.getContent())
                .major(request.getMajor())
                .date(LocalDateTime.now())
                .recommend(0L)
  //              .imageLinks(imageLinks)
                .build());
    }

}