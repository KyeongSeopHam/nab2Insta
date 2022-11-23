package com.cos.photogramstart.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class testjspControl {

    @GetMapping("/hi")
    public String getHi() {
        return "test/t";
    }
}