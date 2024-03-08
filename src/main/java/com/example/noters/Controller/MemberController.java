package com.example.noters.Controller;

import com.example.noters.Entity.NotersMember;
import com.example.noters.Repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody NotersMember member) {
        if (memberRepository.findByEmail(member.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        member.setPassword(member.getPassword());
        memberRepository.save(member);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody NotersMember member) {
        Optional<NotersMember> user = memberRepository.findByEmail(member.getEmail());
        if (user.isEmpty() || !user.get().getPassword().equals(member.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
        return ResponseEntity.ok("User logged in successfully");
    }

}
