package com.arcokim.akwiki.controller;

import com.arcokim.akwiki.domain.Member;
import com.arcokim.akwiki.form.LoginForm;
import com.arcokim.akwiki.form.RegisterForm;
import com.arcokim.akwiki.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "member/login";
    }

    @PostMapping("/login")
    public String loginProcess(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult,
                               HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "member/login";
        }

        Member loginMember = memberService.login(loginForm.getUsername(), loginForm.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "member/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("member", loginMember);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "member/register";
    }

    @PostMapping("/register")
    public String registerProcess(@Validated @ModelAttribute RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/register";
        }

        memberService.register(registerForm.getEmail(), registerForm.getUsername(),
                registerForm.getNickname(), registerForm.getPassword());
        return "redirect:/";
    }

    @GetMapping("/recover")
    public String recover() {
        return "member/recover";
    }
}