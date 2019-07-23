package com.xms.dao;

import com.xms.entity.Dept;
import com.xms.entity.Emp;

import java.util.List;

public interface DeptDao {
    void deptAndEmp(Dept dept, Emp emp);

    List<Emp> empByPage(int page, int pageSize);
}
