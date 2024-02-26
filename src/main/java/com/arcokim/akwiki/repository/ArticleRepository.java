package com.arcokim.akwiki.repository;

import com.arcokim.akwiki.domain.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    void save(Article article);
    Optional<Article> findByTitle(String title);
    List<Article> findAll(String title);
}
