package com.xms.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.xms.dao.EmpDao;
import com.xms.dao.impl.EmpDaoImpl;
import com.xms.entity.Emp;

/**
 * 测试类
 * @author Administrator
 *
 */
public class TestCase {
	EmpDao dao=new EmpDaoImpl();
	
	@Test
	public void testFindAll() {
		//测试方法1
		List<Emp> emps=dao.findAll();
		System.out.println("集合长度:"+emps.size());
		//遍历集合数据
		for (Emp emp : emps) {
			System.out.println(emp.getEmpno()+","
					+emp.getEname());
		}
	}
	
	@Test
	public void testFindByEmpno() {
		//测试方法2
		Emp emp=dao.findByEmpno(1008);
				System.out.println(emp.getEmpno()+","
						+emp.getEname());
	}
	
	@Test
	public void testInserEmp() {
		//测试方法3
		Emp emp=new Emp();
		emp.setEmpno(1022);
		emp.setEname("张三");
		emp.setPosition("Clerk");
		emp.setSalary(1200);
		emp.setBonus(300);
		emp.setHiredate(new Date());//java.util
		emp.setLeader(1013);
		emp.setDeptno(10);
		dao.insertEmp(emp);
	}
	
	@Test
	public void testUpdateEmp() {
		//测试方法4
		Emp emp=new Emp();
		emp.setEmpno(1022);
		emp.setEname("张三1");
		emp.setPosition("Clerk1");
		emp.setSalary(1000);
		emp.setBonus(600);
		try {
			emp.setHiredate(
new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-12"));
		} catch (ParseException e) {
			e.printStackTrace();
		}//java.util
		emp.setLeader(1012);
		emp.setDeptno(20);
		dao.updateEmp(emp);
	}
	//public static void main(String[] args) {
		
		
		
		
		
		//测试方法5
		//dao.deleteEmp(1022);
	//}
}







