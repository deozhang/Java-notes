package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xms.dao.AccountDao;
import com.xms.util.DBCPUtil;
/**
 * ʵ����
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
			//1��ͨ�����ӳػ�ȡ����
			con=DBCPUtil.getConnection();
			//����������ύ��ʽ
			con.setAutoCommit(false);//���Զ��ύ
			//2��������
			//A�˻�
			sql="update account set money=money-? where id=?";
			ps=con.prepareStatement(sql);
			//3��ִ��
			//���ʺŸ�ֵ
			ps.setInt(1, num);
			ps.setString(2, from);
			ps.executeUpdate();//���� ����Ҫ����
			
			//B�˻�
			//������
			sql="update account set money=money+? where id=?";
			ps=con.prepareStatement(sql);
			//���ʺŸ�ֵ
			ps.setInt(1, num);
			ps.setString(2, to);
			//�����쳣
			Integer.parseInt("ab");
			//ִ��
			ps.executeUpdate();//���� ����Ҫ����
			//�����ύ
			con.commit();//���Զ������ֶ��ύ
		} catch (Exception e) {
			try {
				//����ع�
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				//5���黹����
				DBCPUtil.releaseConnection(con, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}





