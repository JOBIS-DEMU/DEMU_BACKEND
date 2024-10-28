package com.example.demu.domain.search.controller;


import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.search.service.SearchService;
import com.example.demu.domain.user.domain.type.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("public/search")
@CrossOrigin
public class SearchController {
    private final SearchService searchService;


    @GetMapping("/title/{keyword}")
    public Optional<List<Post>> searchByTitle(@PathVariable String keyword){
        return searchService.findAllByTittle(keyword);
    }

    @GetMapping("/major/{major}")
    public Optional<List<Post>> searchByMajor(@PathVariable(name = "major") String strMajor){
        return searchService.findAllByMajor(strMajor);
    }

}
