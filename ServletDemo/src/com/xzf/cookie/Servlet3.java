package com.xzf.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String pwd = request.getParameter("password");

        if (username.equals("111") && pwd.equals("222")) {
            Cookie[] cookies = request.getCookies();
            Cookie cookie = CookieUtils.findCookieValue(cookies, "last");

            if (cookie == null) {
                Cookie ck = new Cookie("last", System.currentTimeMillis() + "");
                ck.setMaxAge(60 * 60);
                response.addCookie(ck);
                response.getWriter().write("欢迎你," + username);
            } else {
                long lastTime = Long.parseLong(cookie.getValue());
                response.getWriter().write("欢迎你," + username + ", 上次来访时间是: " + new Date(lastTime));
                cookie.setValue(System.currentTimeMillis()+"");
                response.addCookie(cookie);
            }

        } else {
            response.getWriter().write("登录失败");
        }
    }
}
