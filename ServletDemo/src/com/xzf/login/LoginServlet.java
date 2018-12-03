package com.xzf.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //1.获取数据
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");

        System.out.println("username=" + username + " password=" + pwd);

        //2.校验数据
//        test1(response, username, pwd);

//        method1(response, username, pwd);

        method2(request, response, username, pwd);

    }

    /**
     *
     * @param request 请求
     * @param response 响应
     * @param username 用户名
     * @param pwd 密码
     * @throws ServletException
     * @throws IOException
     *
     * 请求转发和重定向
     */
    private void method2(HttpServletRequest request, HttpServletResponse response, String username, String pwd) throws ServletException, IOException {
        if (username.equals("111") && pwd.equals("222")) {
            //重定向
//            response.sendRedirect("login_success.html");
            //请求转发
            request.getRequestDispatcher("login_success.html").forward(request,response);
        } else {
            response.getWriter().write("登录失败");
        }
    }

    private void method1(HttpServletResponse response, String username, String pwd) {
        if (username.equals("111") && pwd.equals("222")) {
            Object obj = getServletContext().getAttribute("count");
            int totalCount = 0;

            if (obj != null) {
                totalCount = (int) obj;
            }

            getServletContext().setAttribute("count", totalCount + 1);
            //设置状态码 302 重定向
            response.setStatus(302);
            response.setHeader("Location", "login_success.html");
        } else {

        }
    }


    private void test1(HttpServletResponse response, String username, String pwd) throws IOException {
        //向客户端输出内容
        PrintWriter pw = response.getWriter();
        if (username.equals("111") && pwd.equals("222")) {
//            System.out.println("登录成功");
            pw.write("login success...");
        } else {
//            System.out.println("登录失败");
            pw.write("login failed...");
        }
    }
}
