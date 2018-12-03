package com.xzf.download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet1")
public class DownloadServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        method1(request, response);
        method2(request, response);
        return;
    }

    private void method2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = request.getParameter("filename");

        //包含中文名字
        filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
        String path = getServletContext().getRealPath("download/" + filename);

        String clientType = request.getHeader("User-Agent");

        if (clientType.contains("Firefox")) {
            filename = DownLoadUtil.base64EncodingFileName(filename);
        } else {
            filename = URLEncoder.encode(filename, "UTF-8");
        }

        response.setHeader("Content-Disposition", "attachment, filename=" + filename);
        InputStream is = new FileInputStream(path);
        OutputStream os = response.getOutputStream();

        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        os.close();
        is.close();
    }

    private void method1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = request.getParameter("filename");

        response.setHeader("Content-Disposition", "attachment, filename=" + filename);

        String path = getServletContext().getRealPath("download/" + filename);
        InputStream is = new FileInputStream(path);
        OutputStream os = response.getOutputStream();

        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        os.close();
        is.close();
    }

}
