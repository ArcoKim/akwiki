package com.arcokim.akwiki.controller;

import com.arcokim.akwiki.domain.Article;
import com.arcokim.akwiki.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final ArticleService articleService;

    @PostMapping
    public String process_search(@RequestParam String title) {
        Article article = articleService.read(title);

        if (article == null) {
            return "redirect:/search?q=" + title;
        }

        return "redirect:/article/" + title;
    }

    @GetMapping
    public String search(@RequestParam("q") String title) {
        List<Article> search = articleService.search(title);
        log.info("search result = {}", search);
        return "redirect:/";
    }
}
