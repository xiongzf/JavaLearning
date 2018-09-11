package com.xzf.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainTestTest {


    @Test
    public void test1() {
        String sql = "select * from student";
        executeQuery(sql);

    }

    @Test
    public void test2() {
        String sql = "insert into student values(null, '王麻子', 24, '1')";
        executeUpdate(sql);

    }

    @Test
    public void test3() {
        String sql = "delete from student where sid = 7";
        executeUpdate(sql);

    }

    @Test
    public void test4() {
        String sql = "update student set age = 44 where sid = 5";
        executeUpdate(sql);

    }


    private static void executeQuery(String mySql) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            //3、创建 statement，跟数据打交道
            statement = conn.createStatement();

            String sql = mySql;
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

    private static void executeUpdate(String mySql) {
        Connection conn = null;
        Statement statement = null;

        try {
            conn = JDBCUtil.getConnection();
            //3、创建 statement，跟数据打交道
            statement = conn.createStatement();

            String sql = mySql;
            int result = statement.executeUpdate(sql);

            if (result > 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, statement);
        }
    }
}