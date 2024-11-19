package com.ernest.schedule.filters;

import com.ernest.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = {"/schedule/*"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        receive session object
        HttpSession session = request.getSession();

        SysUser sysUser = (SysUser) session.getAttribute("sysUser");

        if (sysUser == null) {
            response.sendRedirect("/login.html");
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
