package com.xzf.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "HelloServlet2")
public class HelloServlet2 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //        System.out.println("123123");

    // 1、获取 Servlet 配置对象, 在 web.xml 中的配置信息
    ServletConfig config = getServletConfig();
    // 获取 Servlet 名称
    String servletName = config.getServletName();
    System.out.println("servletName=" + servletName);

    String address = config.getInitParameter("address");
    System.out.println("address=" + address);

    // 获取所有的参数名称
    Enumeration<String> names = config.getInitParameterNames();
    while (names.hasMoreElements()) {
      String name = (String) names.nextElement();
      System.out.println("name=====" + name);
    }
  }
}
