package com.xzf.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MainTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        method1(conn, statement, rs);

    }

    private static void method1(Connection conn, Statement statement, ResultSet rs) {
        try {
            conn = JDBCUtil.getConnection();
            //3、创建 statement，跟数据打交道
            statement = conn.createStatement();

            String sql = "select * from student";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                int sid = rs.getInt("sid");
                int age = rs.getInt("age");
                String sname = rs.getString("sname");
                String gender = rs.getString("sex").equals("1") ? "男" : "女";

                System.out.println("sid = " + sid + " sname = " + sname + " age = " + age + " sex = " + gender );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, statement, rs);
        }
    }
}
