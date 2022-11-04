package com.cos.photogramstart.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // 디비에 테이블을 생성
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호증가 전략이 데이트베이스를 따라간다.
    private int id;

    @Column (unique = true)
    private String username;
    private String password;

    private String name;
    private String website; // 웹사이트
    private String bio;   // 자기소개
    private String email;  // 이메일
    private String phone;  // 전화번호
    private String gender; // 성별

    private String profileImageUrl; // 작성자 사진 (유저 사진)
    private String role; // 권한


    private LocalDateTime createDate; // 이데이터가 언제들어왔는지확인하기위해

    @PrePersist // 디비에 INSERT 되기 직전에 실행
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }
}
