package com.example.demu.domain.post.domain.repository;

import com.example.demu.domain.post.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post,Long> {
}
