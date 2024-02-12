package com.arcokim.akwiki.controller;

import com.arcokim.akwiki.form.RegisterForm;
import com.arcokim.akwiki.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "member/register";
    }

    @PostMapping(value = "/register")
    public String registerProcess(@Validated @ModelAttribute RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("bindingResult = {}", bindingResult);
            return "member/register";
        }

        memberService.register(registerForm);
        return "redirect:/";
    }

    @GetMapping("/recover")
    public String recover() {
        return "member/recover";
    }
}