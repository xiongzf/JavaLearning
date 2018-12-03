package com.xzf.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie ck : cookies) {
                System.out.println(ck.getName() + "=" + ck.getValue());
            }
        }

        Cookie cookie1 = new Cookie("name", "zhangsan");
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("age", "21");
        response.addCookie(cookie2);

        //设置 cookie 有效期
        //正值:表示在这个数字之后, cookie 将会失效
        //负值:关闭浏览器,那么 cookie 就失效,默认值-1
        cookie1.setMaxAge(60 * 60 * 24);
        cookie2.setMaxAge(-1);

        //用于指定只有请求了指定的域名,才会带上该 cookie
        cookie1.setDomain(".com");
        //只有访问该域名下的 cookie1 的这个路径地址才会带上 cookie
        cookie1.setPath("/cookie1");

        response.getWriter().write("hello cookies");
    }
}
