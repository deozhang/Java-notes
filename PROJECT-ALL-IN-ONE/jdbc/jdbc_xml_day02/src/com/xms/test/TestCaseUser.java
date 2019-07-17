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
    }
    @Test
    public void testPreparedStatement(){
        dao.loginByPreparedStatement("deo","111");
    }
}
