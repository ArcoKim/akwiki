package com.arcokim.akwiki.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Record {
    private Member contributor;
    private LocalDateTime time;

    private Record(Member contributor, LocalDateTime time) {
        this.contributor = contributor;
        this.time = time;
    }

    public static Record create(Member contributor, LocalDateTime time) {
        return new Record(contributor, time);
    }
}
