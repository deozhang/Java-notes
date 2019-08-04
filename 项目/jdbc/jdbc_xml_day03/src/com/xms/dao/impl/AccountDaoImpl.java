package com.xms.dao.impl;

import com.xms.dao.AccountDao;
import com.xms.util.DBCPUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void translate(String from, String to, int num) {
        //PreparedStatement
        Connection conn = null;
        PreparedStatement ps = null;
        String sql=null;
        try {
            //1.通过连接池获取连接
            conn=DBCPUtil.getConnection();
            conn.setAutoCommit(false);
            //2.语句对象
            //A账户
            sql="update account set money=money-? where id=?";
            ps=conn.prepareStatement(sql);
            //3.执行
            //给问号赋值
            ps.setInt(1,num);
            ps.setString(2,from);
            ps.executeUpdate();//更新 不需要参数
            //制造异常
            Integer.parseInt("a");
            //B账户
            //语句对象
            sql="update account set money=money+? where id=?";
            //给问号赋值
            ps.setInt(1,num);
            ps.setString(2,to);
            //执行
            ps.executeUpdate();//更新 不需要参数
            //事务提交
            conn.commit();//不自动提交，必须手动提交
        } catch (SQLException e) {
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
