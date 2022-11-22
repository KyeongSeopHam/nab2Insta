package com.cos.photogramstart.web.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testControl {
    @GetMapping("/hello")
    public String getT(){
        return "hello getT";
    }
}
