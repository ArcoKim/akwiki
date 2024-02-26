package com.arcokim.akwiki.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Article {
    @Setter
    private Long id;
    private String title;
    private String body;
    LocalDateTime update_time;
    private List<Long> contributors;

    public Article(String title, String body, LocalDateTime update_time, List<Long> contributors) {
        this.title = title;
        this.body = body;
        this.update_time = update_time;
        this.contributors = contributors;
    }
}
