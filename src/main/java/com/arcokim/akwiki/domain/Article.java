package com.arcokim.akwiki.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Article {
    @Setter
    private Long id;
    private String title;
    private String body;
    private List<Record> history;

    private Article(String title, String body, List<Record> history) {
        this.title = title;
        this.body = body;
        this.history = history;
    }

    public static Article create(String title, String body, Member member, LocalDateTime time) {
        Record record = Record.create(member, time);
        List<Record> history = new ArrayList<>();
        history.add(record);
        return new Article(title, body, history);
    }
}
