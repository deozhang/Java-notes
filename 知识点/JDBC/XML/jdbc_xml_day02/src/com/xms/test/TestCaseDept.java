package com.xms.test;

import java.util.List;

import org.junit.Test;

import com.xms.dao.DeptDao;
import com.xms.dao.impl.DeptDaoImpl;
import com.xms.entity.Dept;

/**
 * 测试类
 * @author Administrator
 *
 */
public class TestCaseDept {
	DeptDao dao=new DeptDaoImpl();
	//注解
	@Test
	public void testFindAll() {
		List<Dept> depts=dao.findAll();
		System.out.println("集合长度:"+depts.size());
		//遍历数据
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
		dept.setDname("市场部1");
		dept.setLocation("南京");
		dao.insertDept(dept);
	}
	
	@Test
	public void testUpdateDept() {
		Dept dept=new Dept();
		dept.setDeptno(60);
		dept.setDname("市场部2");
		dept.setLocation("杭州");
		dao.updateDept(dept);
	}
	
}





