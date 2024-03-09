package com.example.noters.Entity;

import javax.persistence.*;


@Entity
@Table(name = "noters_members")
public class NotersMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;

    // 생성자
    public NotersMember() {
        // 기본 생성자
    }

    public NotersMember(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    // 게터, 세터
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}