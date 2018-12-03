package com.xzf.servletDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(name = "ServletDemo")
public class ServletDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 根据 classloader 去获取工程下的资源 类加载器()
     * @throws IOException
     */
    private void test4() throws IOException {
        //1.创建属性对象
        Properties properties = new Properties();
        //2.指定载入数据源
        /**
         * Classloader 相对路径
         */
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("../../files/config.properties");
        properties.load(is);

        //3.获取属性的值
        String name = properties.getProperty("name");
        System.out.println("name=" + name);
    }

    private void test3() throws IOException {
        //1.创建属性对象
        Properties properties = new Properties();
        //2.指定载入数据源.获取 web 工程下的资源,转化成对象,前面隐藏当前工程的根目录.
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream("files/config.properties");
        properties.load(is);

        //3.获取属性的值
        String name = properties.getProperty("name");
        System.out.println("name=" + name);
    }

    private void test2() throws IOException {
        //1.创建属性对象
        Properties properties = new Properties();
        //2.指定载入数据源
        /**
         * 此处如果想获取 web 工程下的资源,用普通的 FileInputStream 写法是不行的.
         * 因为路径不对,这里相对的路径,其实是根据 jre 来确定的,但我们这是一个 web 工程.
         * jre 后面会由 tomcat 管理,所以这里真正的相对路径是 tomcat 里面的 bin 目录.
         */
//        InputStream is = new FileInputStream("classes/config.properties");

        ServletContext context = getServletContext();
        String path = context.getRealPath("files/config.properties");
        InputStream is = new FileInputStream(path);
        properties.load(is);

        //3.获取属性的值
        String name = properties.getProperty("name");
        System.out.println("name=" + name);
    }

    private void test1() {
        System.out.println("来了一个请求,哈哈哈哈");
        //1.获取对象
        ServletContext context = getServletContext();

        String phone = (String) context.getInitParameter("phone");
        System.out.println("phone=" + phone);
    }
}
