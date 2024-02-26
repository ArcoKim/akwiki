package com.arcokim.akwiki.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Member {
    @Setter
    private Long id;
    private String email;
    private String username;
    private String nickname;
    private String password;

    public Member(String email, String username, String nickname, String password) {
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }
}
