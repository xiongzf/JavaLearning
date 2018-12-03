<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/10/16
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
    你的购物车商品如下:
    <%
        //1.现获取 map
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");

        //2.遍历
        if (map != null) {
            for (String key : map.keySet()) {
                int value = map.get(key);
    %>
        <h3>名称: <%=key%>      数量:<%=value%></h3>
    <%
            }
    %>
        <a href="/clearCart"><h4>清空购物车</h4></a>
    <%
        }
    %>
</body>
</html>
