package com.xms.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.xms.dao.EmpDao;
import com.xms.dao.impl.EmpDaoImpl;
import com.xms.entity.Emp;

/**
 * ������
 * @author Administrator
 *
 */
public class TestCase {
	public static void main(String[] args) {
		EmpDao dao=new EmpDaoImpl();
		/*//���Է���1
		List<Emp> emps=dao.findAll();
		System.out.println("���ϳ���:"+emps.size());
		//������������
		for (Emp emp : emps) {
			System.out.println(emp.getEmpno()+","
					+emp.getEname());
		}*/
		
		//���Է���2
		/*Emp emp=dao.findByEmpno(1008);
		System.out.println(emp.getEmpno()+","
				+emp.getEname());*/
		
		/*//���Է���3
		Emp emp=new Emp();
		emp.setEmpno(1022);
		emp.setEname("����");
		emp.setPosition("Clerk");
		emp.setSalary(1200);
		emp.setBonus(300);
		emp.setHiredate(new Date());//java.util
		emp.setLeader(1013);
		emp.setDeptno(10);
		dao.insertEmp(emp);*/
		
		/*//���Է���4
		Emp emp=new Emp();
		emp.setEmpno(1022);
		emp.setEname("����1");
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
		dao.updateEmp(emp);*/
		
		//���Է���5
		dao.deleteEmp(1022);
	}
}







