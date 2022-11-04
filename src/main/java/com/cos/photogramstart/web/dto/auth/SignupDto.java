package com.cos.photogramstart.web.dto.auth;

// 통신할떄 필요할 데이터를 담아두는 Object
// dto Req

import com.cos.photogramstart.domain.user.User;
import lombok.Data;

@Data
public class SignupDto {
    private String username;
    private String password;
    private String email;
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
