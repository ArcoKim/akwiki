package com.arcokim.akwiki;

import com.arcokim.akwiki.domain.Article;
import com.arcokim.akwiki.domain.Member;
import com.arcokim.akwiki.repository.ArticleRepository;
import com.arcokim.akwiki.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class TestDataInit {

    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        Member admin = Member.create("admin@example.com", "admin", "관리자", "admin1234!");
        memberRepository.save(admin);

        Article article = Article.create("Admin", "Admin[어드민]은 관리자입니다.", admin, LocalDateTime.now());
        articleRepository.save(article);
    }
}
