package com.xms.test;

import com.xms.dao.EmpDao;
import com.xms.dao.impl.EmpDaoImpl;
import com.xms.entity.Emp;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestCase {
//    public static void main(String[] args) {
        EmpDao dao = new EmpDaoImpl();
        //测试方法
//        List<Emp> emps = dao.findAll();
//        System.out.println("集合长度："+emps.size());
//        //遍历集合数据
//        for (Emp emp:emps
//             ) {
//            System.out.println(emp.getEmpno()+","+emp.getEname());
//        }
        //测试方法2
//        Emp emp = dao.findByEmpno(1004);
//        System.out.println(emp.getEmpno()+","+emp.getEname());
        //测试方法3
//        Emp emp = new Emp();
//        emp.setEmpno(1024);
//        emp.setEname("Deo");
//        emp.setPosition("Clerk");
//        emp.setSalary(1200);
//        emp.setBonus(300);
//        emp.setHiredate(new Date());//java.util
//        emp.setLeader(1013);
//        emp.setDeptno(10);
//        dao.insertEmp(emp);
        //测试方法4
//        Emp emp = null;
//        emp.setEmpno(1023);
//        emp.setEname("Deo1");
//        emp.setPosition("Clerk1");
//        emp.setSalary(1200);
//        emp.setBonus(300);
//        try {
//            emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-12"));//java.util
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        emp.setLeader(1013);
//        emp.setDeptno(10);
//        dao.insertEmp(emp);
        //测试方法5
//        dao.deleteEmp(1020);
//    }
    @Test
        public void testFindAll(){
            List<Emp> emps = dao.findAll();
                System.out.println("集合长度："+emps.size());
                //遍历集合数据
                for (Emp emp:emps
                    ) {
                    System.out.println(emp.getEmpno()+","+emp.getEname());
                }
    }
    @Test
    public void testFindByEmpno(){
        Emp emp = dao.findByEmpno(1004);
        System.out.println(emp.getEmpno()+","+emp.getEname());
    }
    @Test
    public void testInsertEmp(){
        Emp emp = new Emp();
        emp.setEmpno(1025);
        emp.setEname("Deo");
        emp.setPosition("Clerk");
        emp.setSalary(1200);
        emp.setBonus(300);
        emp.setHiredate(new Date());//java.util
        emp.setLeader(1013);
        emp.setDeptno(10);
        dao.insertEmp(emp);
    }
    @Test
    public void testUpdateEmp(){
        Emp emp = new Emp();
        emp.setEmpno(1025);
        emp.setEname("Sunny");
        emp.setPosition("Clerk1");
        emp.setSalary(1200);
        emp.setBonus(300);
        try {
            emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-12"));//java.util
        } catch (ParseException e) {
            e.printStackTrace();
        }
        emp.setLeader(1013);
        emp.setDeptno(10);
        dao.insertEmp(emp);
    }

}
