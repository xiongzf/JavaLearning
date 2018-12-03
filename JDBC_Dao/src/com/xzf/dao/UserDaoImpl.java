package com.xzf.dao;

import com.xzf.jdbc.JDBCUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public void findAll() {
        String sql = "select * from user";
        executeQuery(sql);
    }

    @Override
    public void login(String username, String pwd) {
//        String sql = "select * from user where name = '" + username + "' and pwd = '" + pwd + "'";
//        executeQuery(sql);

        String sql = "select * from user where name = ? and pwd = ?";
        eQuery(sql, username, pwd);
    }

    @Override
    public void insert(String username, String pwd) {
        String sql = "insert into user values(null, ?, ?)";
        eUpdate(sql, username, pwd);
    }


    private void eQuery(String mySql, String... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            //3、创建 statement，跟数据打交道
            ps = conn.prepareStatement(mySql);

            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
            }

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("有数据");
            } else {
                System.out.println("没有数据");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, ps, rs);
        }
    }

    private void eUpdate(String mySql, String... params) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            //3、创建 statement，跟数据打交道
            ps = conn.prepareStatement(mySql);

            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
            }

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, ps);
        }
    }

    private void executeQuery(String mySql) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            //3、创建 statement，跟数据打交道
            statement = conn.createStatement();

            rs = statement.executeQuery(mySql);

            while (rs.next()) {
                int uid = rs.getInt("uid");
                String name = rs.getString("name");
                String pwd = rs.getString("pwd");
                System.out.println("uid = " + uid + " name = " + name + " pwd = " + pwd );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, statement, rs);
        }
    }

    private void executeUpdate(String mySql) {
        Connection conn = null;
        Statement statement = null;

        try {
            conn = JDBCUtil.getConnection();
            //3、创建 statement，跟数据打交道
            statement = conn.createStatement();

            int result = statement.executeUpdate(mySql);

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
