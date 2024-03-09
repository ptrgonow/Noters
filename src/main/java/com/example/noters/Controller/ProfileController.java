package com.example.noters.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 프로필 페이지를 반환하는 컨트롤러
@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}