package com.xms.dao.impl;

import com.xms.dao.DeptDao;
import com.xms.entity.Dept;
import com.xms.util.DButil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Dept> depts = new ArrayList<Dept>();

        try {
            conn = DButil.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from dept_zhang";
            rs = stmt.executeQuery(sql);
            Dept dept = null;
            while (rs.next()){
                dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLocation(rs.getString("location"));
                depts.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DButil.closeConnection(conn,stmt,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return depts;
    }

    @Override
    public Dept findByDeptno(int deptno) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Dept dept = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from dept_zhang where deptno="+deptno;
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                dept = new Dept();
                dept.setDeptno(rs.getInt(1));
                dept.setDname(rs.getString(2));
                dept.setLocation(rs.getString(3));

            }
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DButil.closeConnection(conn,stmt,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dept;
    }

    @Override
    public void insertDept(Dept dept) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into dept_zhang values("+dept.getDeptno()+",'"
                    +dept.getDname()+"','"+dept.getLocation()+"')";
            System.out.println("sql statement:"+sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DButil.closeConnection(conn,stmt,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void updataDept(Dept dept) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.createStatement();
            String sql = "update dept_zhang set location='" +dept.getLocation()
                    +"' where deptno="+dept.getDeptno()+"";
            System.out.println("sql statement:"+sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDept(int deptno) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from dept_zhang where deptno="+deptno;
            System.out.println("sql statement:"+sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DButil.closeConnection(conn,stmt,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
