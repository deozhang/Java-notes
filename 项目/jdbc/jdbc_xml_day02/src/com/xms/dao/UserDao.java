package com.xms.dao;

public interface UserDao {
    //登陆检测
    void loginByStatement(String username,String pwd);

    void loginByPreparedStatement(String username,String pwd);
}
