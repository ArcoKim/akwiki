package com.arcokim.akwiki.repository;

import com.arcokim.akwiki.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findByUsername(String username);
}
