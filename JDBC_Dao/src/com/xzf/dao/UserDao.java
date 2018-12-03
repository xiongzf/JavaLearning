package com.xzf.dao;

public interface UserDao {
    /**
     * 查找所有
     */
    void findAll();

    /**
     *
     * @param username 用户名
     * @param pwd 密码
     */
    void login(String username, String pwd);

    /**
     *
     * @param username 用户名
     * @param pwd 密码
     */
    void insert(String username, String pwd);
}
