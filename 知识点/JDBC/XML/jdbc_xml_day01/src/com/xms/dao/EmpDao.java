package com.xms.dao;

import java.util.List;

import com.xms.entity.Emp;

/**
 * �ӿ�
 * @author Administrator
 *
 */
public interface EmpDao {
	//1����ѯȫ��Ա����Ϣ
	List<Emp> findAll();
	//2������Ա���Ų�ѯԱ����Ϣ
	Emp findByEmpno(int empno);
	//3������һ��Ա����Ϣ
	void insertEmp(Emp emp);
	//4������һ����¼
	void updateEmp(Emp emp);
	//5��ɾ��һ����¼
	void deleteEmp(int empno);
}
 


