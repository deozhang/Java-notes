package com.xms.test;

import com.xms.dao.UserDao;
import com.xms.dao.impl.UserDaoImpe;
import com.xms.entity.User;
import org.junit.Test;

public class TestCaseUser {
    UserDao dao = new UserDaoImpe();
    @Test
    public void testStatement(){
        User user = new User();
        dao.loginByStatement("deo","111");
        //'a' or '1'='1'
        //正确的用户名和伪造的密码，预期结果是"登陆失败"
        //实际结果是"登陆成功",Statement是不安全的
        dao.loginByStatement("deo","a' or '1'='1");
    }
    @Test
    public void testPreparedStatement(){
        dao.loginByPreparedStatement("deo","111");
        //正确的用户名和伪造的密码，预期结果是"登陆失败"
        //实际结果是"登陆失败"，PreparedStatement能够预防SQL注入
        dao.loginByPreparedStatement("deo","a' or '1'='1");
    }
}
