package com.xzf.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductInfoServlet")
public class ProductInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前用户准备浏览的商品 ID
        String id = request.getParameter("id");

        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.findCookieValue(cookies, "history");

        if (cookie == null) {
            Cookie ck = new Cookie("history", id);
            ck.setMaxAge(60 * 60 * 24);
            response.addCookie(ck);

            response.sendRedirect("product_info.html");
        } else {
            //1.获取以前的 cookie, 因为以前的 cookie, 包含了浏览记录
            String ids = cookie.getValue();
            //2.让以前浏览的商品和现在浏览的商品形成新的 cookie 值
            cookie.setValue(id + "#" + ids);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);

            response.sendRedirect("product_info.html");
        }
    }
}
