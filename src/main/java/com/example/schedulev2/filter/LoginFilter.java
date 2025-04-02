package com.example.schedulev2.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

public class LoginFilter implements Filter {
    private static final String  WHITE_LIST = "/login";  // 대문자로

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (!WHITE_LIST.equals(requestURI)) {
            HttpSession httpSession = request.getSession(false);

            if (httpSession==null || httpSession.getAttribute("sessionKey")==null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"로그인이 필요합니다");
            }
        }

        filterChain.doFilter(request,response);
    }

}
