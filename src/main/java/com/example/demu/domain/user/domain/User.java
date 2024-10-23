package com.example.demu.domain.user.domain;


import com.example.demu.domain.user.domain.type.Grade;
import com.example.demu.domain.user.domain.type.Major;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "account_id", nullable = false, columnDefinition = "VARCHAR(60)")
    private String accountId;

    //게시물 번호(post_id) 추가해야함.
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String nickname;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
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
    private int point;


    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updateIntro(String intro) {
        this.intro = intro;
    }

    public void updateMajor(Major major) {
        this.major = major;
    }

    public void plusPoint() {
        this.point += 1;
        this.grade = getGradeByPoints(this.point);
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public Grade getGradeByPoints(int point) {
//        return switch (point) {
//            case 0 -> Grade.BRONZE;
//            case 10 -> Grade.SILVER;
//            case 25 -> Grade.GOLD;
//            case 45 -> Grade.PLATINUM;
//            case 70 -> Grade.DIAMOND;
//            default -> throw new RuntimeException("point error");
       // };
//    return switch (point) {
//            case 10 -> Grade.SILVER;
//            case 25 -> Grade.GOLD;
//            case 45 -> Grade.PLATINUM;
//            case 70 -> Grade.DIAMOND;
//            default -> Grade.BRONZE;
//        };

    if(point<10){
        return Grade.BRONZE;
        }
    else if(point<25){
        return Grade.SILVER;
    }
    else if(point<45){
        return Grade.GOLD;
    }
    else if(point<70){
        return Grade.PLATINUM;
    }
    else{
        return Grade.DIAMOND;
    }

    }

}
