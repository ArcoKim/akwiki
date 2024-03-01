package com.arcokim.akwiki.controller;

import com.arcokim.akwiki.domain.Article;
import com.arcokim.akwiki.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final ArticleService articleService;

    @PostMapping
    public String searchProcess(@RequestParam String title) {
        Article article = articleService.read(title);

        if (article == null) {
            return "redirect:/search?q=" + title;
        }

        return "redirect:/article/" + title;
    }

    @GetMapping
    public String search(@RequestParam("q") String title, Model model) {
        List<Article> search = articleService.search(title);
        model.addAttribute("search", search);
        return "article/search";
    }
}
