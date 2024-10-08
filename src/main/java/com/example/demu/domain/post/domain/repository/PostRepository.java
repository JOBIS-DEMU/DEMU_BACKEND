package com.example.demu.domain.post.domain.repository;

import com.example.demu.domain.post.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
