package com.xms.test;

import com.xms.dao.AccountDao;
import com.xms.dao.impl.AccountDaoImpl;
import org.junit.Test;

public class TestCaseAccount {
    @Test
    public void testTranslate(){
        AccountDao dao=new AccountDaoImpl();
        dao.translate("a","b",500);
    }
}
