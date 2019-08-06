package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xms.dao.AccountDao;
import com.xms.util.DBCPUtil;
/**
 * 实现类
 * @author Administrator
 *
 */
public class AccountDaoImpl implements AccountDao {

	@Override
	public void translate(String from, String to, int num) {
		//PreparedStatement
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;	
		try {
			//1、通过连接池获取连接
			con=DBCPUtil.getConnection();
			//设置事务的提交方式
			con.setAutoCommit(false);//不自动提交
			//2、语句对象
			//A账户
			sql="update account set money=money-? where id=?";
			ps=con.prepareStatement(sql);
			//3、执行
			//给问号赋值
			ps.setInt(1, num);
			ps.setString(2, from);
			ps.executeUpdate();//更新 不需要参数
			
			//B账户
			//语句对象
			sql="update account set money=money+? where id=?";
			ps=con.prepareStatement(sql);
			//给问号赋值
			ps.setInt(1, num);
			ps.setString(2, to);
			//制造异常
			Integer.parseInt("ab");
			//执行
			ps.executeUpdate();//更新 不需要参数
			//事务提交
			con.commit();//不自动必须手动提交
		} catch (Exception e) {
			try {
				//事务回滚
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				//5、归还连接
				DBCPUtil.releaseConnection(con, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}





