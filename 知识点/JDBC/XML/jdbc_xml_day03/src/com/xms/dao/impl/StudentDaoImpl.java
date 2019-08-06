package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.xms.dao.StudentDao;
import com.xms.util.DBCPUtil;
/**
 * 实现类
 * @author Administrator
 *
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public void insertBatch() {
		//批量增加
		Connection con=null;//java.sql
		Statement st=null;
		
		try {
			//1、连接池获取连接
			con=DBCPUtil.getConnection();
			//设置事务提交方式
			con.setAutoCommit(false);
			//2、语句对象
			st=con.createStatement();
			//3、执行
			//通过循环方式构造待处理SQL语句
			String sql=null;
			for(int i=1;i<=100;i++) {
				sql="insert into stu_xu values("+i+",'张三')";
				//将sql语句添加到语句对象列表
				st.addBatch(sql);
			}
			//批处理
			st.executeBatch();
			//事务提交
			con.commit();
			//清空语句对象列表
			st.clearBatch();
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
				//4、归还连接
				DBCPUtil.releaseConnection(con, st, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteBatch() {
		//PreparedStatement
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1、连接(con赋值)
			con=DBCPUtil.getConnection();
			//设置事务提交方式
			con.setAutoCommit(false);
			//2、语句对象
			String sql="delete from stu_xu where id=?";
			ps=con.prepareStatement(sql);
			//3、执行
			for(int i=1;i<=100;i++) {
				//给问号赋值
				ps.setInt(1, i);
				//将语句添加到列表
				ps.addBatch();
			}
			//批处理
			ps.executeBatch();
			//事务提交
			con.commit();
			//清空
			ps.clearBatch();
			
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
				//4、连接归还
				DBCPUtil.releaseConnection(con, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}




