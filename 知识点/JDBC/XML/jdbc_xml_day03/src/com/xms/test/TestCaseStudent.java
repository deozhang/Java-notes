package com.xms.test;

import org.junit.Test;

import com.xms.dao.StudentDao;
import com.xms.dao.impl.StudentDaoImpl;

/**
 * ≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class TestCaseStudent {
	StudentDao dao=new StudentDaoImpl();
	@Test
	public void testInsertBatch() {
		dao.insertBatch();
	}
	@Test
	public void testDeleteBatch() {
		dao.deleteBatch();
	}
}






