package com.example.demu.domain.search.controller;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.search.service.SearchService;
import com.example.demu.domain.user.domain.type.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;


    @GetMapping("/search/title")
    public Optional<List<Post>> searchByTitle(@RequestParam String keyword){
        return searchService.findAllByTittle(keyword);
    }

    @GetMapping("/search/major")
    public Optional<List<Post>> searchByMajor(@RequestParam Major major){
        return searchService.findAllByMajor(major);
    }

}
