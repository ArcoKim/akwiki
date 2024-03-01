package com.arcokim.akwiki;

import com.arcokim.akwiki.controller.interceptor.BaseInterceptor;
import com.arcokim.akwiki.controller.interceptor.CreateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CreateInterceptor())
                .order(1)
                .addPathPatterns("/article/create");

        registry.addInterceptor(new BaseInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/images/**", "/scripts/**", "/webfonts/**", "/*.ico", "/error");
    }
}
