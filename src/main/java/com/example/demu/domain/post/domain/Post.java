package com.example.demu.domain.post.domain;

import java.util.*;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.type.Major;
import lombok.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column(columnDefinition = "VARCHAR(50)")
    private String title;

    @Lob
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime date;

    @Builder.Default
    private Long recommend = 0L;

    @Enumerated(EnumType.STRING)
    private Major major;

    @ElementCollection
    private List<String> imageLinks;
    public void updatePost(String title, String content, Major major) {
        this.title = title;
        this.content = content;
        this.major = major;
    }

    public void addRecommend() {
        this.recommend += 1;
    }
}
