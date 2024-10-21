package com.example.demu.domain.post.domain.repository;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.post.dto.response.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> , JpaSpecificationExecutor<Post> {
}
