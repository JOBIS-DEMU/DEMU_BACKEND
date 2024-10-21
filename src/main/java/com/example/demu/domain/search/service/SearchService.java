package com.example.demu.domain.search.service;


import com.example.demu.domain.user.domain.type.Major;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchService {
    //private final PostRepository postRepository;

//    private Specification<Post> titleContains(String keyword){
//            return new Specification<Post>() {
//                @Override
//                public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                    query.distinct(true);
//                    return criteriaBuilder.like(root.get("title"), "%" + keyword + "%");
//                }
//            };
//        }
//
//        private Specification<Post> majorContains(Major major){
//            return new Specification<Post>() {
//                @Override
//                public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                    return criteriaBuilder.equal(root.get("major"), major);
//                }
//            };
//        }
//
//    public Optional<List<Post>> findAllByTittle(String keyword){
//        return Optional.ofNullable(postRepository.findAll(titleContains(keyword)));
//    }
//
//    public Optional<List<Post>> findAllByMajor(Major major){
//        return Optional.ofNullable(postRepository.findAll(majorContains(major)));
//    }


}