package com.example.noters.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 홈페이지를 반환하는 컨트롤러
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}

