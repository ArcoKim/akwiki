package com.arcokim.akwiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @RequestMapping("/login")
    public String login() {
        return "member/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "member/register";
    }

    @RequestMapping("/recover")
    public String recover() {
        return "member/recover";
    }
}