package com.example.demu.domain.post.domain.repository;

import com.example.demu.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends JpaRepository<Post,Long> , JpaSpecificationExecutor<Post> {

}
