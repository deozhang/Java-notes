package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xms.dao.DeptDao;
import com.xms.entity.Dept;
import com.xms.util.DBUtil;
/**
 * ʵ����
 * @author Administrator
 *
 */
public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> findAll() {
		Connection con=null;//java.sql
		Statement st=null;
		ResultSet rs=null;
		//����
		List<Dept> depts=new ArrayList<Dept>();
		
		try {
			//1��ͨ���������ȡ����
			con=DBUtil.getConnection();
			//2��������
			st=con.createStatement();
			//3��ִ��SQL���
			String sql="select * from dept_xu";
			rs=st.executeQuery(sql);//��ѯ
			//4����������
			Dept dept=null;
			while(rs.next()) {
				dept=new Dept();
				//ȡ���ݸ�����ֵ
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLocation(rs.getString("location"));
				//��������ӵ�����
				depts.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//5���ر���Դ
				DBUtil.closeConnection(con, st, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return depts;
	}

	@Override
	public Dept findByDeptno(int deptno) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//����
		Dept dept=null;
		
		try {
			//1������
			con=DBUtil.getConnection();
			//2��������
			st=con.createStatement();
			//3��ִ��
			String sql="select * from dept_xu where deptno="+deptno;
			rs=st.executeQuery(sql);//��ѯ
			//4����������
			if(rs.next()) {
				dept=new Dept();
				//ȡ���ݸ�����ֵ
				//rs.getXXX(�ֶ���|����)
				dept.setDeptno(rs.getInt(1));
				dept.setDname(rs.getString(2));
				dept.setLocation(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//5���ر���Դ
				DBUtil.closeConnection(con, st, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dept;
	}

	@Override
	public void insertDept(Dept dept) {
		Connection con=null;
		Statement st=null;
		
		try {
			//1������
			con=DBUtil.getConnection();
			//2��������
			st=con.createStatement();
			//3��ִ��
			String sql="insert into dept_xu values("
					+dept.getDeptno()+",'"+dept.getDname()
					+"','"+dept.getLocation()+"')";
			//��ӡ
			System.out.println("sql���:"+sql);
			st.executeUpdate(sql);//����
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4���ر���Դ
				DBUtil.closeConnection(con, st, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateDept(Dept dept) {
		Connection con=null;
		Statement st=null;
		
		try {
			//1������
			con=DBUtil.getConnection();
			//2��������
			st=con.createStatement();
			//3��ִ��
			String sql="update dept_xu set dname='"
					+dept.getDname()+"',location='"
					+dept.getLocation()+"' where deptno="
					+dept.getDeptno()+"";
			//��ӡ
			System.out.println("sql���:"+sql);
			st.executeUpdate(sql);//����
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4���ر���Դ
				DBUtil.closeConnection(con, st, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteDept(int deptno) {

	}

}
