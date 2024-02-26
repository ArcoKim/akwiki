package com.arcokim.akwiki.controller;

import com.arcokim.akwiki.domain.Article;
import com.arcokim.akwiki.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{title}")
    public String read(@PathVariable String title, Model model) {
        Article article = articleService.read(title);
        model.addAttribute("article", article);

        String formattedDate = article.getUpdate_time()
                .format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        model.addAttribute("formattedDate", formattedDate);
        return "article/read";
    }
}
