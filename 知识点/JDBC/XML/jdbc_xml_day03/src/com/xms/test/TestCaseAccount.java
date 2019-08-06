package com.xms.test;

import org.junit.Test;

import com.xms.dao.AccountDao;
import com.xms.dao.impl.AccountDaoImpl;

/**
 * ≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class TestCaseAccount {
	@Test
	public void testTranslate() {
		AccountDao dao=new AccountDaoImpl();
		dao.translate("A", "B", 500);
	}
}






