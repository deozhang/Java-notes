package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.xms.dao.StudentDao;
import com.xms.util.DBCPUtil;
/**
 * ʵ����
 * @author Administrator
 *
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public void insertBatch() {
		//��������
		Connection con=null;//java.sql
		Statement st=null;
		
		try {
			//1�����ӳػ�ȡ����
			con=DBCPUtil.getConnection();
			//���������ύ��ʽ
			con.setAutoCommit(false);
			//2��������
			st=con.createStatement();
			//3��ִ��
			//ͨ��ѭ����ʽ���������SQL���
			String sql=null;
			for(int i=1;i<=100;i++) {
				sql="insert into stu_xu values("+i+",'����')";
				//��sql�����ӵ��������б�
				st.addBatch(sql);
			}
			//������
			st.executeBatch();
			//�����ύ
			con.commit();
			//����������б�
			st.clearBatch();
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
				//4���黹����
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
			//1������(con��ֵ)
			con=DBCPUtil.getConnection();
			//���������ύ��ʽ
			con.setAutoCommit(false);
			//2��������
			String sql="delete from stu_xu where id=?";
			ps=con.prepareStatement(sql);
			//3��ִ��
			for(int i=1;i<=100;i++) {
				//���ʺŸ�ֵ
				ps.setInt(1, i);
				//�������ӵ��б�
				ps.addBatch();
			}
			//������
			ps.executeBatch();
			//�����ύ
			con.commit();
			//���
			ps.clearBatch();
			
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
				//4�����ӹ黹
				DBCPUtil.releaseConnection(con, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}




