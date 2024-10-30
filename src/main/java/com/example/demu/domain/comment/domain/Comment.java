package com.example.demu.domain.comment.domain;

//import com.example.demu.domain.post.domain.Post;
import com.example.demu.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @JoinColumn(name = "post_id")
   // @ManyToOne
   // private Post post;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column(columnDefinition = "VARCHAR(300)")
    private String content;

}
