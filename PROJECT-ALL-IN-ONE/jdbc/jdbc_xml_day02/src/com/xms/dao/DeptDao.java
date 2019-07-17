package com.xms.dao;

import com.xms.entity.Dept;

import java.util.List;

public interface DeptDao {
    //1. Query all dept info
    List<Dept> findAll();

    //2.
    Dept findByDeptno(int deptno);
    //3.
    void insertDept(Dept dept);
    //4.
    void updataDept(Dept dept);
    //5.
    void deleteDept(int deptno);
}
