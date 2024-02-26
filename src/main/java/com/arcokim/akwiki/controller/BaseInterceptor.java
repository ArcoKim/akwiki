package com.arcokim.akwiki.controller;

import com.arcokim.akwiki.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Slf4j
public class BaseInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getMethod().equals("GET")) {
            String ip = getClientIpAddr(request);
            HttpSession session = request.getSession();
            Member member = (Member) session.getAttribute("member");

            log.info("[{}] Base injection completed", request.getRequestURI());
            ModelMap modelMap = modelAndView.getModelMap();
            modelMap.addAttribute(new Base(member, ip));
        }
    }

    private String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if(ip == null || ip.isEmpty()) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.isEmpty()) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.isEmpty()) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if(ip == null || ip.isEmpty()) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}
