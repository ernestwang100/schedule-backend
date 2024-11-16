package com.ernest.schedule.controller;

import com.ernest.schedule.common.Result;
import com.ernest.schedule.common.ResultCodeEnum;
import com.ernest.schedule.pojo.SysUser;
import com.ernest.schedule.service.SysUserService;
import com.ernest.schedule.service.impl.SysUserServiceImpl;
import com.ernest.schedule.utils.MD5Util;
import com.ernest.schedule.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private final SysUserService userService = new SysUserServiceImpl();

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("run regist");
        // Log headers and body for debugging
        String username = req.getParameter("username");
        String password =  req.getParameter("password");
        System.out.println("username = " + username + " password = " + password);

//        logRequestDetails(req);

        // Get the request body object
//        SysUser registUser = WebUtil.readJson(req, SysUser.class);
        SysUser registUser = new SysUser(null, username, password);
        int rows = userService.regist(registUser);
        System.out.println("rows = " + rows);
        Result result = null;
        // Based on the registration result (success or failure), redirect the page
        if (rows > 0) {
            result = Result.ok(null);
            System.out.println("success");
        } else {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
            System.out.println("fail");
        }
        WebUtil.writeJson(resp, result);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SysUser loginUser = WebUtil.readJson(req, SysUser.class);
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        System.out.println("username = " + username + " password = " + password);

        SysUser user = userService.findByUsername(username);
        Result result = null;
        if (null == user) {
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        } else if (!MD5Util.encrypt(password).equals(user.getPassword())) {
            // Check if the password matches
            result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        } else {
            req.getSession().setAttribute("sysUser", user);
            // Hide the password before returning it to the client
            user.setPassword("******");
            result = Result.ok(user);
        }
        WebUtil.writeJson(resp, result);
    }

    public void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        SysUser registUser = userService.findByUsername(username);
        Result result = null;
        if (null == registUser) {
            result = Result.ok(null);
        } else {
            // Username is taken, create an object with result code 505
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        // Convert the result object to JSON and respond to the client
        WebUtil.writeJson(resp, result);
    }

    private void logRequestDetails(HttpServletRequest req) {
        // Print request headers
        System.out.println("Headers:");
        req.getHeaderNames().asIterator().forEachRemaining(headerName ->
                System.out.println(headerName + ": " + req.getHeader(headerName)));

        // Print request body
        try (BufferedReader reader = req.getReader()) {
            System.out.println("Body:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading request body: " + e.getMessage());
        }
    }

}

