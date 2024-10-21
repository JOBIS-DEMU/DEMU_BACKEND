package com.example.demu.domain.post.domain;

import com.example.demu.domain.user.domain.User;
import com.example.demu.domain.user.domain.type.Major;
import io.lettuce.core.output.StringListOutput;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
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

    private Long recommend;

    @Enumerated(EnumType.STRING)
    private Major major;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> images;


    public void updatePost(String title, String content, Major major) {
        this.title = title;
        this.content = content;
        this.major = major;
    }

}
