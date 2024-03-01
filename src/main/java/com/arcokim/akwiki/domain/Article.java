package com.arcokim.akwiki.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Article {
    @Setter
    private Long id;
    private String title;
    private String body;
    private List<Record> history = new ArrayList<>();

    private Article(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void addRecord(Record record) {
        history.add(record);
    }

    public static Article create(String title, String body, Member member, LocalDateTime time) {
        Article article = new Article(title, body);
        Record record = Record.create(member, time);
        article.addRecord(record);
        return article;
    }
}
