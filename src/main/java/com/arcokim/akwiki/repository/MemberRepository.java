package com.arcokim.akwiki.repository;

import com.arcokim.akwiki.domain.Member;

public interface MemberRepository {
    Member save(Member member);
}
