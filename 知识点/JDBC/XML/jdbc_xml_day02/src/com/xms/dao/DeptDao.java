package com.xms.dao;

import java.util.List;

import com.xms.entity.Dept;

/**
 * �ӿ�
 * @author Administrator
 *
 */
public interface DeptDao {
	//1����ѯȫ��������Ϣ
	List<Dept> findAll();
	
	//2�����ݲ��źŲ�ѯ������Ϣ
	Dept findByDeptno(int deptno);
	
	//3�����ű�����һ����¼
	void insertDept(Dept dept);
	
	//4�����ű����һ����¼
	void updateDept(Dept dept);
	
	//5�����ű�ɾ��һ����¼
	void deleteDept(int deptno);
}
