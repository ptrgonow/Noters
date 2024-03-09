package com.example.noters.Service;

import com.example.noters.Entity.NotersMember;
import com.example.noters.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveMember(NotersMember member) {
        // 비밀번호 해시화
        String hashedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(hashedPassword);

        memberRepository.save(member);
    }
}