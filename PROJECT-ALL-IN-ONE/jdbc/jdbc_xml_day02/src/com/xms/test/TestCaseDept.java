package com.xms.test;

import com.xms.dao.DeptDao;
import com.xms.dao.impl.DeptDaoImpl;
import com.xms.entity.Dept;
import org.junit.Test;

import java.util.List;

public class TestCaseDept {

    @Test
    public void testFindAll(){
        DeptDao dao = new DeptDaoImpl();
        List<Dept> depts = dao.findAll();
        System.out.println("Set length:"+depts.size());
        for (Dept dept:
             depts) {
            System.out.println(dept.getDeptno()+","+dept.getDname() +","
                    +dept.getLocation());

        }
    }
    @Test
    public void b(){
        System.out.println("testB");
    }
}
