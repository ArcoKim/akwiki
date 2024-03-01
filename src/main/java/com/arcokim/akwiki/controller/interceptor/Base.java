package com.arcokim.akwiki.controller.interceptor;

import com.arcokim.akwiki.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Base {
    private final Member member;
    private final String ip;
}
