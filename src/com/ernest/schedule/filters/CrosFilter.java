package com.ernest.schedule.filters;


import com.ernest.schedule.common.Result;
import com.ernest.schedule.utils.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CrosFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT,OPTIONS, DELETE, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");
        // If it's a cross-origin preflight request, the request method is OPTIONS
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            WebUtil.writeJson(response, Result.ok(null));
        } else {
            // Non-preflight requests, simply allow the request to pass through
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
