package com.example.demu.domain.user.domain;

import com.example.demu.domain.user.domain.type.Grade;
import com.example.demu.domain.user.domain.type.Major;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {
    @Id
    @Column(nullable = false,columnDefinition = "VARCHAR(60)")
    private String accountId;

    //게시물 번호(post_id) 추가해야함.
    @Column(nullable = false,columnDefinition = "VARCHAR(50)")
    private String nickname;

    @Column(nullable = false,columnDefinition = "VARCHAR(60)")
    private String password;

    @Enumerated(EnumType.STRING) //enum 인덱스 대신 bronze,silver 등의 string 값으로 저장
    @Column(nullable = false)
    private Grade grade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Major major;

    @Column(columnDefinition = "TEXT")
    private String intro;

    @Column(nullable = false)
    @ColumnDefault("0") // DB 에 들어갈 컬럼의 초기값 설정.
    private long point;
}
