package com.arcokim.akwiki.service;

import com.arcokim.akwiki.domain.Member;
import com.arcokim.akwiki.form.RegisterForm;
import com.arcokim.akwiki.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void register(RegisterForm registerForm) {
        Member member = new Member(registerForm.getEmail(), registerForm.getUsername(),
                registerForm.getNickname(), registerForm.getPassword());
        memberRepository.save(member);
    }
}
