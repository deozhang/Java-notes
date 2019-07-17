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
    public Dept findByDeptno(Dept dept) {
        return null;
    }

    @Override
    public void insertDept(Dept dept) {

    }

    @Override
    public void updataDept(Dept dept) {

    }

    @Override
    public void deleteDept(int deptno) {

    }
}
