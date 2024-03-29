package com.arcokim.akwiki.service;

import com.arcokim.akwiki.domain.Member;
import com.arcokim.akwiki.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void register(String email, String username, String nickname, String password) {
        Member member = Member.create(email, username, nickname, password);
        memberRepository.save(member);
    }

    public Member login(String username, String password) {
        return memberRepository.findByUsername(username)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
