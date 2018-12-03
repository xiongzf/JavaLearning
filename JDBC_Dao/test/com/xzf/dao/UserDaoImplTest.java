package com.xzf.dao;


import org.junit.Test;

public class UserDaoImplTest {

    @Test
    public void testFindAll() {
        UserDao dao = new UserDaoImpl();
        dao.findAll();
    }

    @Test
    public void testLogin() {
        UserDao dao = new UserDaoImpl();
        dao.login("admin", "adminssss' or '1=1");
//        dao.login("admin", "admin");
    }

    @Test
    public void testInsert() {
        UserDao dao = new UserDaoImpl();
        dao.insert("zhangsan", "123456");
    }
}