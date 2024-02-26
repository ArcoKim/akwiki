package com.arcokim.akwiki.repository;

import com.arcokim.akwiki.domain.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class MemoryArticleRepository implements ArticleRepository {

    private static Map<Long, Article> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public void save(Article article) {
        article.setId(++sequence);
        log.info("saved article = {}", article);
        store.put(sequence, article);
    }

    @Override
    public Optional<Article> findByTitle(String title) {
        return store.values().stream()
                .filter(article -> article.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Article> findAll(String title) {
        return store.values().stream()
                .filter(article -> article.getTitle().contains(title))
                .collect(Collectors.toList());
    }
}
