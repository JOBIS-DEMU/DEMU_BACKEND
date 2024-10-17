package com.example.demu.domain.comment.domain;

import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_comment")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "post_id")
    @ManyToOne
    private Post postId;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;

    @Column(columnDefinition = "VARCHAR(300)")
    private String content;
}
