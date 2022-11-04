package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity  // 해당 파일로 시큐리티를 활성화
@Configuration // IOC
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // csrf 비활성화

        // super.configure(http);  // 기존시큐리티가 가지고있는 기능이 다 비활성화됨. (super 삭제시)
        http.authorizeRequests()
                .antMatchers("/","/user/**","/image/**","/subscribe/**","/comment/**").authenticated() // 인증이필요한페이지는아무나못들어감
                .anyRequest().permitAll()    //해당 주소들만 인증이 필요하고  그게아닌 모든주소는  허용함
                .and()                   //근데 다른주소쳤을시 걍 로그인페이지로가게해보자.and.formLogin.loginPage("/auth/signin")
                .formLogin() // 인증이필요한 요청이오면 formLogin을할건데 그 폼로그인 페이지를 /auth/signin 임
                .loginPage("/auth/signin")  // 열로 리다이렉션
                .defaultSuccessUrl("/"); // 로그인성공시 이페이지로가게하자

    }
}