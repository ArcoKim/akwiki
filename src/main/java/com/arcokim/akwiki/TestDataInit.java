package com.arcokim.akwiki;

import com.arcokim.akwiki.domain.Member;
import com.arcokim.akwiki.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TestDataInit {

    private final MemberRepository memberRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        Member admin = new Member("admin@example.com", "admin", "관리자", "admin1234!");
        memberRepository.save(admin);
    }
}
