package com.cos.photogramstart.web;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.config.auth.PrincipalDetailsService;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

   @GetMapping("/user/{id}")
    public String profile(@PathVariable int id){
       return "user/profile";
   }

   @GetMapping("/user/{id}/update")
    public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails){
       //1 추천
       System.out.println("세션정보 :"+principalDetails.getUser());

//       model.addAttribute("principal",principalDetails.getUser());
       return "user/update";
   }

}
