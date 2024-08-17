package com.example.asmj6;

import com.example.asmj6.interceptor.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    GlobalInterceptor gi;

    //muốn interceptor áp dụng cho những url nào thì cần cấu hình cho nó
    @Override
    //đưa globalinterceptor vào registry của hệ thống
    public void addInterceptors(InterceptorRegistry registry) {
        //chắn tất ngoại trừ rest, admin và assets
        registry.addInterceptor(gi)
                .addPathPatterns("/**")
                .excludePathPatterns("/rest/**", "/admin/**", "/assets/**");
    }
}
