package test;

import java.util.List;

import org.junit.Test;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

public class TestDAO {
	@Test
	public void test1() throws Exception {
		AdminDAO dao = new AdminDAOImpl();
		List<Admin> list = dao.findAll();
		System.out.println(list);
	}
}
