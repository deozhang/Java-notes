package com.xms.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;
/**
 * ʵ����
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//����:��Ŷ������
		List<Emp> emps=new ArrayList<Emp>();
		
		try {
			//1������������������
			//ͨ���������ʵ����Driver������
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsd", 
					"root", "1234");//java.sql
			//2������������
			st=con.createStatement();
			//3��ִ��SQL���
			String sql="select * from emp_xu";
			rs=st.executeQuery(sql);//��ѯ
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
				//�����
				if(rs!=null) {
					rs.close();
				}
				//������
				if(st!=null) {
					st.close();
				}
				//����
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emps;
	}

	@Override
	public Emp findByEmpno(int empno) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//����
		Emp emp=null;
		try {
			//1������������������
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/jsd", 
					"root", "1234");
			//2������������
			st=con.createStatement();
			//3��ִ��SQL���
			String sql="select * from emp_xu where empno="+empno;
			rs=st.executeQuery(sql);//��ѯ
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
				if(rs!=null) {
					rs.close();
				}
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
		return emp;
	}

	@Override
	public void insertEmp(Emp emp) {
		Connection con=null;
		Statement st=null;
		try {
			//1������������������
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsd",
					"root", "1234");
			//2������������
			st=con.createStatement();
			//3��ִ��SQL���
			String sql="insert into emp_xu values("
					+emp.getEmpno()+",'"+emp.getEname()
					+"','"+emp.getPosition()+"',"
					+emp.getSalary()+","+emp.getBonus()
					+",date_format('"
					+new Date(emp.getHiredate().getTime())
					+"','%X-%m-%d'),"+emp.getLeader()+","
					+emp.getDeptno()+")";//java.sql.Date(������)
			//��ӡ:��֤SQL�����ȷ��
			System.out.println("sql���:"+sql);
			int i=st.executeUpdate(sql);//����
			System.out.println("iֵ:"+i);
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

	@Override
	public void updateEmp(Emp emp) {
		Connection con=null;
		Statement st=null;
		
		try {
			//1������������������
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsd",
					"root", "1234");
			//2������������
			st=con.createStatement();
			//3��ִ��SQL���
			String sql="update emp_xu set ename='"
					+emp.getEname()+"',position='"
					+emp.getPosition()+"',salary="
					+emp.getSalary()+",bonus="+emp.getBonus()
					+",hiredate=date_format('"
					+new Date(emp.getHiredate().getTime())
					+"','%X-%m-%d'),leader="+emp.getLeader()
					+",deptno="+emp.getDeptno()
					+" where empno="+emp.getEmpno()+"";
			//��ӡ
			System.out.println("sql���:"+sql);
			st.executeUpdate(sql);//����
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






