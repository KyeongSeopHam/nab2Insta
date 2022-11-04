package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor  // final 필드를 DI할떄 사용
@Controller // ioC등록 , 파일을리턴하는컨트롤러
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

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
    public String signup(SignupDto signupDto){  // 회원가입을 진행할거  key= value (x-www-form-urlencoded)

        log.info(signupDto.toString());
       // User Obejct <- signupDto의데이터를 넣어야하는데

        User user = signupDto.toEntity();
        log.info(user.toString());
       User userEntity=  authService.회원가입(user);
        System.out.println(userEntity);
        return "auth/signin"; // 회원가입 성공하면  -> 로그인페이지로
    }

}
