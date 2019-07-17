package com.xms.test;

import com.xms.dao.DeptDao;
import com.xms.dao.impl.DeptDaoImpl;
import com.xms.entity.Dept;
import org.junit.Test;

import java.util.List;

public class TestCaseDept {

    DeptDao dao = new DeptDaoImpl();
    @Test
    public void testFindAll(){
        List<Dept> depts = dao.findAll();
        System.out.println("Set length:"+depts.size());
        for (Dept dept:
             depts) {
            System.out.println(dept.getDeptno()+","+dept.getDname() +","
                    +dept.getLocation());

        }
    }
    @Test
    public void testFindByDeptno(){
        Dept dept = dao.findByDeptno(10);
        System.out.println(dept.getDeptno()+","+dept.getDname()+","
                +dept.getLocation());
    }
    @Test
    public void testInsert(){
        Dept dept = new Dept();
        dept.setDeptno(60);
        dept.setDname("mark");
        dept.setLocation("Hefei");
        dao.insertDept(dept);
    }
    @Test
    public void TustUpdate(){
        Dept dept = new Dept();
        dept.setDeptno(10);
        dept.setLocation("Beijing");
        dao.updataDept(dept);
    }
    @Test
    public void TestDelete(){
        Dept dept = new Dept();
        dept.setDeptno(60);
        dao.deleteDept(dept.getDeptno());
    }
}
