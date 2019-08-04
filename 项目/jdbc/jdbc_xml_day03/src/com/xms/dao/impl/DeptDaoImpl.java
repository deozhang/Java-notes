package com.xms.dao.impl;

import com.xms.dao.DeptDao;
import com.xms.entity.Dept;
import com.xms.entity.Emp;
import com.xms.util.DBCPUtil;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public void deptAndEmp(Dept dept, Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        //用于接收自增类型数据
        ResultSet rs = null;
        try {
            //1.连接
            conn = DBCPUtil.getConnection();
            //设置事务的提交方式
            conn.setAutoCommit(false);
            //2.语句对象
            String sql = "insert into dept_zhang(dname,location) values(?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //给？赋值
            ps.setString(1,dept.getDname());
            ps.setString(2,dept.getLocation());
            ps.executeUpdate();//增加，不需要参数
            //获取自增类型的数据
            rs = ps.getGeneratedKeys();
            //取部门号
            int deptno=0;
            if(rs.next()){
                 deptno=rs.getInt(1);
            }
            System.out.println("自增部门号："+deptno);
            //往员工表中插入一条记录
            sql="insert into emp_zhang(ename,deptno) values(?,?)";
            //执行
            ps = conn.prepareStatement(sql);
            //给问号赋值
            ps.setString(1,emp.getEname());
            ps.setInt(2,deptno);//返回的部门号
            ps.executeUpdate();//增加 不要参数
            //事务提交
            conn.commit();
            ps=conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //归还连接
                DBCPUtil.releaseConnection(conn,ps,rs);
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Emp> empByPage(int page, int pageSize) {
        List<Emp> emps = new LinkedList<Emp>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBCPUtil.getConnection();
            String sql = "select * from emp_zhang limit ?,?";
            ps = conn.prepareStatement(sql);
            //问号赋值
            int begin = (page-1)*pageSize;
            ps.setInt(1,begin);
            ps.setInt(2,pageSize);
            //执行
            rs = ps.executeQuery();//查询
            Emp emp = null;
            while (rs.next()){
                emp = new Emp();
                //取数据给对象赋值
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setPosition(rs.getString(3));
                emp.setSalary(rs.getDouble(4));
                emp.setBonus(rs.getDouble(5));
                emp.setHiredate(rs.getDate(6));
                emp.setLeader(rs.getInt(7));
                emp.setDeptno(rs.getInt(8));
                emps.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBCPUtil.releaseConnection(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emps;
    }
}
