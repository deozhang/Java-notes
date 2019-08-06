package com.xms.test;

import java.util.List;

import org.junit.Test;

import com.xms.dao.DeptDao;
import com.xms.dao.impl.DeptDaoImpl;
import com.xms.entity.Dept;

/**
 * ������
 * @author Administrator
 *
 */
public class TestCaseDept {
	DeptDao dao=new DeptDaoImpl();
	//ע��
	@Test
	public void testFindAll() {
		List<Dept> depts=dao.findAll();
		System.out.println("���ϳ���:"+depts.size());
		//��������
		for (Dept dept : depts) {
			System.out.println(dept.getDeptno()+","+
		dept.getDname()+","+dept.getLocation());
		}
	}
	
	
	@Test
	public void testFindByDeptno() {
		Dept dept=dao.findByDeptno(10);
		System.out.println(dept.getDeptno()+","+
		dept.getDname()+","+dept.getLocation());
	}
	
	@Test
	public void testInsertDept() {
		Dept dept=new Dept();
		dept.setDeptno(60);
		dept.setDname("�г���1");
		dept.setLocation("�Ͼ�");
		dao.insertDept(dept);
	}
	
	@Test
	public void testUpdateDept() {
		Dept dept=new Dept();
		dept.setDeptno(60);
		dept.setDname("�г���2");
		dept.setLocation("����");
		dao.updateDept(dept);
	}
	
}





