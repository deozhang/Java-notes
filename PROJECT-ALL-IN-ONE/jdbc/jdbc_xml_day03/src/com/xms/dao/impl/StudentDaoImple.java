package com.xms.dao.impl;

import com.xms.dao.StudentDao;
import com.xms.util.DBCPUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDaoImple implements StudentDao {
    @Override
    public void insertBatch() {
        //批量增加
        Connection conn=null;
        Statement stmt=null;

        try {
            //1.连接池获取连接
            conn= DBCPUtil.getConnection();
            //设置事务提交方式
            conn.setAutoCommit(false);
            //2.语句对象
            stmt = conn.createStatement();
            //3.执行
            //通过循环的方式构造待处理SQL语句
            String sql=null;
            for (int i = 100; i < 150; i++) {
                sql="insert into stu_zhang values("+i+",'deo')";
                //将SQL语句添加到语句对象列表
                stmt.addBatch(sql);
            }
            //批处理
            stmt.executeBatch();
            //事务提交
            conn.commit();
            //清空语句
            stmt.clearBatch();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            try {
                DBCPUtil.releaseConnection(conn , stmt,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteBatch() {
        //批量删除
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //1.连接池获取连接
            conn = DBCPUtil.getConnection();
            //设置事务提交方式
            conn.setAutoCommit(false);
            //语句对象
            String sql = null;
            sql="delete from stu_zhang where id=?";
            ps = conn.prepareStatement(sql);
            //执行
            for (int i = 0; i < 100; i++) {
                //给?赋值
                ps.setInt(1,i);
                //将语句添加到列表中
                ps.addBatch();
            }
            //批处理
            ps.executeBatch();

            //事务处理
            conn.commit();
            //清空语句
            ps.clearBatch();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                DBCPUtil.releaseConnection(conn,ps,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
