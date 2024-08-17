package com.example.asmj6.interceptor;

import com.example.asmj6.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
    //hiển thị danh mục thì hiển thị trong mọi layout nên ko thể viết trong
    //1 controller cụ thể nào, thay vào đó sẽ viết vào interceptor
    @Autowired
    CategoryService cs;
    //nên viết trong postHandle thay vì preHandle vì sau khi thực hiện phương
    //thức trong controller xong mới chạy
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("categories", cs.findAll());
    }
}
