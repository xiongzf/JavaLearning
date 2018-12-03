package com.xzf.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "HeaderDemo")
public class HeaderDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        method1(request);

//        method2(request);
        request.setCharacterEncoding("UTF-8");

    }

    private void method2(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = map.get(key)[0];

            System.out.println(key + "====" + value);
        }
    }

    private void method1(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement();
            String value = (String) request.getHeader(headerName);
            System.out.println("name = " + headerName + "        value = " + value);
        }
    }
}
