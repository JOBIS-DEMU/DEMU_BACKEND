package com.example.demu.domain.post.domain;

import com.example.demu.domain.comment.domain.Comment;
import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.type.Major;
import io.lettuce.core.output.StringListOutput;
import lombok.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    private LocalDateTime date;

    @Builder.Default
    private Long recommend = 0L;

    @Enumerated(EnumType.STRING)
    private Major major;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> images;


    public void updatePost(String title, String content, Major major) {
        this.title = title;
        this.content = content;
        this.major = major;
    }

    public void addRecommend() {
        this.recommend += 1;
    }

}
