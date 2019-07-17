package com.xms.dao;

import java.util.List;
import com.xms.entity.Emp;

public interface EmpDao {
    List<Emp> findAll();
    Emp findByEmpno(int empno);
    void insertEmp(Emp emp);
    void updateEmp(Emp emp);
    void deleteEmp(int empno);
}
