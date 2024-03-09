 package com.example.noters.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 여행지 페이지를 반환하는 컨트롤러
@Controller
public class DestinationController {

    @GetMapping("/destinations")
    public String destinations() {
        return "destinations";
    }
}

