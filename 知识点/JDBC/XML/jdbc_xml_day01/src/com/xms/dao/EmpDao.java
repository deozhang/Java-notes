package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;

/**
 * 接口
 * @author Administrator
 *
 */
public interface EmpDao {
	//1、查询全部员工信息
	List<Emp> findAll();
	//2、根据员工号查询员工信息
	Emp findByEmpno(int empno);
	//3、增加一条员工信息
	void insertEmp(Emp emp);
	//4、更新一条记录
	void updateEmp(Emp emp);
	//5、删除一条记录
	void deleteEmp(int empno);
}
 


