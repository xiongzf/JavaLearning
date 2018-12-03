package com.xzf.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "ShoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //1.获取要添加到购物车的商品 id
        int id = Integer.parseInt(request.getParameter("id"));
        String[] names = {"iPhoneXS", "小米8", "三星 note10", "魅族16", "华为 mate10"};
        String name = names[id];

        //2.获取购物车存放东西的 session Map<String, Integer>
        Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");

        if (map == null) {
            //session 里面没有存放任何东西
            map = new LinkedHashMap<String, Integer>();
            request.getSession().setAttribute("cart", map);
        }

        //3.判断购物车里有没有该商品
        if (map.containsKey(name)) {
            map.put(name, map.get(name) + 1);
        } else {
            map.put(name, 1);
        }

        //4.输出界面
        response.getWriter().write("<a href='product_list.jsp'><h3>继续购物</h3></a>");
        response.getWriter().write("<a href='cart.jsp'><h3>去购物车结算</h3></a>");
    }
}
