package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;
import com.xms.util.DBUtil;
/**
 * ʵ����
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		Connection con=null;
		PreparedStatement ps=null;//java.sql
		ResultSet rs=null;
		//����:��Ŷ������
		List<Emp> emps=new ArrayList<Emp>();
		
		try {
			//1������
			con=DBUtil.getConnection();
			//2������������
			//����������ʱ��Ҫһ��Ԥ�����SQL���
			String sql="select * from emp_xu";
			ps=con.prepareStatement(sql);
			//3��ִ��SQL���
			rs=ps.executeQuery();//��ѯ ��������Ҫ����
			//4����������
			Emp emp=null;
			while(rs.next()) {
				//������
				//��װһ������
				emp=new Emp();
				//������ֵ
				//rs.getXXX("�ֶ���"):�ֶ�����ʾ��ѯ�����
				//���ض�Ӧ���ֶ���
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setPosition(rs.getString("position"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setLeader(rs.getInt("leader"));
				emp.setDeptno(rs.getInt("deptno"));
				//��������ӵ�����
				emps.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5���ر���Դ
			try {
				DBUtil.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emps;
	}

	@Override
	public Emp findByEmpno(int empno) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//����
		Emp emp=null;
		try {
			//1������
			con=DBUtil.getConnection();
			//2������������
			//������������ҪԤ����SQL��䣬SQL�������Ҫ������
			//�ط����ʺ�(����Ӣ��״̬�µ�)��Ϊռλ��
			String sql="select * from emp_xu where empno=?";
			ps=con.prepareStatement(sql);
			//3��ִ��SQL���
			//���ִ��֮ǰ������ʺŸ�ֵ
			//ps.setXXX(�ʺŵ��±�,�ʺŵ�ֵ):�±��1��ʼ
			ps.setInt(1, empno);
			//ִ��
			rs=ps.executeQuery();//��ѯ ��������Ҫ����
			//4����������
			if(rs.next()) {
				//������
				emp=new Emp();
				//ȡ���ݸ�����ֵ
				//rs.getXXX(����):���ֱ�ʾ��ѯ�������Ӧ
				//�ֶε��е�˳��(��1��ʼ)
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setPosition(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setBonus(rs.getDouble(5));
				emp.setHiredate(rs.getDate(6));
				emp.setLeader(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5����Դ�ر�
			try {
				DBUtil.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	@Override
	public void insertEmp(Emp emp) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//1������
			con=DBUtil.getConnection();
			//2������������
			String sql="insert into emp_xu values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			//3��ִ��SQL���
			//���ʺŸ�ֵ
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getPosition());
			ps.setDouble(4, emp.getSalary());
			ps.setDouble(5, emp.getBonus());
			//java.util.Date->java.sql.Date
			ps.setDate(6,new Date(emp.getHiredate().getTime()) );
			ps.setInt(7, emp.getLeader());
			ps.setInt(8, emp.getDeptno());
			//ִ��
			ps.executeUpdate();//���� ����Ҫ����
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4���ر���Դ
				DBUtil.closeConnection(con, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateEmp(Emp emp) {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1����������������
			con=DBUtil.getConnection();
			//2������������
			String sql="update emp_xu set ename=?,position=?,salary=?,bonus=?,hiredate=?,leader=?,deptno=? where empno=?";
			ps=con.prepareStatement(sql);
			//3��ִ��SQL���
			//���ʺŸ�ֵ
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getPosition());
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getBonus());
			//java.sql.Date
			ps.setDate(5, new Date(emp.getHiredate().getTime()));
			ps.setInt(6, emp.getLeader());
			ps.setInt(7, emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			//ִ��
			ps.executeUpdate();//���� ����Ҫ����
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4���ر���Դ
				DBUtil.closeConnection(con, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteEmp(int empno) {
		Connection con=null;
		Statement st=null;
		try {
			//1������������������
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/jsd",
					"root", "1234");
			//2��������
			st=con.createStatement();
			//3��ִ��SQL���
			String sql="delete from emp_xu where empno="+empno;
			st.executeUpdate(sql);//ɾ��
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4���ر���Դ
				if(st!=null) {
					st.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}






