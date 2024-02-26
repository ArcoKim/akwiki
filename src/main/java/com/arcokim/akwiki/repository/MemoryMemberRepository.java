package com.arcokim.akwiki.repository;

import com.arcokim.akwiki.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public void save(Member member) {
        member.setId(++sequence);
        log.info("saved member = {}", member);
        store.put(member.getId(), member);
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return store.values().stream()
                .filter(member -> member.getUsername().equals(username))
                .findAny();
    }
}
