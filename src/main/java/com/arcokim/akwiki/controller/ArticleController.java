package com.arcokim.akwiki.controller;

import com.arcokim.akwiki.domain.Article;
import com.arcokim.akwiki.domain.Member;
import com.arcokim.akwiki.form.CreateForm;
import com.arcokim.akwiki.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{title}")
    public String read(@PathVariable String title, Model model) {
        Article article = articleService.read(title);
        model.addAttribute("article", article);
        return "article/read";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("createForm", new CreateForm());
        return "article/create";
    }

    @PostMapping("/create")
    public String createProcess(@Validated @ModelAttribute CreateForm createForm, BindingResult bindingResult,
                                 @SessionAttribute("member") Member member) {
        if (bindingResult.hasErrors()) {
            return "article/create";
        }

        Article article = Article.create(createForm.getTitle(), createForm.getBody(), member, LocalDateTime.now());
        articleService.create(article);

        return "redirect:/article/" + article.getTitle();
    }
}
