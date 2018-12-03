package com.xzf.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseServlet")
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //1.方式一
//        response.setCharacterEncoding("UTF-8");
        //2.方式二
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");
//        response.getWriter().write("<h1>hello response</h1>");

        response.setContentType("text/html;charset=UTF-8");
        response.getOutputStream().write("哈哈哈哈哈哈".getBytes());

    }
}
