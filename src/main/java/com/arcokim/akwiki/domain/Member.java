package com.arcokim.akwiki.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Member {
    @Setter
    private Long id;
    private String email;
    private String username;
    private String nickname;
    private String password;

    private Member(String email, String username, String nickname, String password) {
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }

    public static Member create(String email, String username, String nickname, String password) {
        return new Member(email, username, nickname, password);
    }
}
