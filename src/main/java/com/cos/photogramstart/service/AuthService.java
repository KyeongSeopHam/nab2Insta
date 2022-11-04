package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service // 1.IOC  2. 트랜젝션관리
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional // Wrtie(insert,update,delete)
    public User 회원가입(User user) {
        String rawPassword =user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);  // 암호화된 패스워드(해쉬로)
        user.setPassword(encPassword);
        user.setRole("ROLE_USER"); // 관리자는 ROLE_ADMIN
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}

/*
  User user 는 외부에서 통신을 통해서 받은데이터를 User Obejct에 담은거고
   userEntity는 db에있는 데이터를 User Obj에 담은거
 userEntity를 거는이유? : save가 된이후에 (db에들어간뒤에) 응답받으려고
   <S extends T> S save(S var1); 이게머지
   =>
    S타입을 집어넣고 그타입으로(S타입을) 리턴받는다?
   내가넣은타입 user

 */
