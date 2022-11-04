package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ioC등록 , 파일을리턴하는컨트롤러
public class AuthController {

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin";
    }

    @GetMapping("/auth/signup")  // 아랫거랑 주소같지만 디스패쳐가 구분하기위해서 Get/Post
    public String signupForm(){
        return "auth/signup";
    }
 // 회원가입버튼-> /auth/signup  -> /auth/signin
    // 회원가입버튼 -> X ???
    @PostMapping("/auth/signup")
    public String signup(){  // 회원가입을 진행할거
        return "auth/signin"; // 회원가입 성공하면  -> 로그인페이지로
    }

}
