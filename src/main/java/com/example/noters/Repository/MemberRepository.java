package com.example.noters.Repository;

import com.example.noters.Entity.NotersMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MemberRepository extends JpaRepository< NotersMember, Long> {

    Optional<NotersMember> findByEmail(String email);
}