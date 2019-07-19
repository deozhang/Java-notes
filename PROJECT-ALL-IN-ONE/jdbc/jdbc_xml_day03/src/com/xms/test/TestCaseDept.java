package com.xms.test;

import com.xms.dao.DeptDao;
import com.xms.dao.impl.DeptDaoImpl;
import com.xms.entity.Dept;
import com.xms.entity.Emp;
import org.junit.Test;

import java.util.List;

public class TestCaseDept {
    DeptDao dao = new DeptDaoImpl();
    @Test
    public void testDeptAndEmp(){
        Dept dept = new Dept();
        dept.setDname("sale1");
        dept.setLocation("nanjing1");
        Emp emp = new Emp();
        emp.setEname("didi1");
        dao.deptAndEmp(dept,emp);
    }
    @Test
    public void testEmpByPage(){
        //select * from emp_zhang limit 5,5;
        List<Emp> emps = dao.empByPage(2,5);
        //遍历
        for (Emp emp :
                emps) {
            System.out.println(emp.getEmpno()+","+emp.getEname());
        }
    }
}
