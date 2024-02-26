package com.arcokim.akwiki.service;

import com.arcokim.akwiki.domain.Article;
import com.arcokim.akwiki.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article read(String title) {
        return articleRepository.findByTitle(title).orElse(null);
    }

    public List<Article> search(String title) {
        return articleRepository.findAll(title);
    }
}
