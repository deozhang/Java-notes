package com.xms.dao;

import java.util.List;

import com.xms.entity.Dept;

/**
 * 接口
 * @author Administrator
 *
 */
public interface DeptDao {
	//1、查询全部部门信息
	List<Dept> findAll();
	
	//2、根据部门号查询部门信息
	Dept findByDeptno(int deptno);
	
	//3、部门表增加一条记录
	void insertDept(Dept dept);
	
	//4、部门表更新一条记录
	void updateDept(Dept dept);
	
	//5、部门表删除一条记录
	void deleteDept(int deptno);
}
