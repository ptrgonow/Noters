package com.example.noters.Controller;


import com.example.noters.Entity.NotersMember;
import com.example.noters.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


        @GetMapping("/signup")
        public String showSignUpForm(Model model) {
            model.addAttribute("member", new NotersMember());
            return "signup";
        }

    @PostMapping("/signup")
    public String signUp(@Valid NotersMember member, BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }

        memberService.saveMember(member);
        return "redirect:/login";
    }

}