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
 * 实现类
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//集合:存放多个对象
		List<Emp> emps=new ArrayList<Emp>();
		
		try {
			//1、加载驱动创建连接
			//通过反射机制实例化Driver驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsd", 
					"root", "1234");//java.sql
			//2、创建语句对象
			st=con.createStatement();
			//3、执行SQL语句
			String sql="select * from emp_xu";
			rs=st.executeQuery(sql);//查询
			//4、处理结果集
			Emp emp=null;
			while(rs.next()) {
				//有数据
				//封装一个对象
				emp=new Emp();
				//给对象赋值
				//rs.getXXX("字段名"):字段名表示查询结果集
				//返回对应的字段名
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setPosition(rs.getString("position"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setLeader(rs.getInt("leader"));
				emp.setDeptno(rs.getInt("deptno"));
				//将对象添加到集合
				emps.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5、关闭资源
			try {
				//结果集
				if(rs!=null) {
					rs.close();
				}
				//语句对象
				if(st!=null) {
					st.close();
				}
				//连接
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
		//对象
		Emp emp=null;
		try {
			//1、加载驱动创建连接
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/jsd", 
					"root", "1234");
			//2、创建语句对象
			st=con.createStatement();
			//3、执行SQL语句
			String sql="select * from emp_xu where empno="+empno;
			rs=st.executeQuery(sql);//查询
			//4、处理结果集
			if(rs.next()) {
				//有数据
				emp=new Emp();
				//取数据给对象赋值
				//rs.getXXX(数字):数字表示查询结果集对应
				//字段的列的顺序(从1开始)
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
			//5、资源关闭
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
			//1、加载驱动创建连接
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsd",
					"root", "1234");
			//2、创建语句对象
			st=con.createStatement();
			//3、执行SQL语句
			String sql="insert into emp_xu values("
					+emp.getEmpno()+",'"+emp.getEname()
					+"','"+emp.getPosition()+"',"
					+emp.getSalary()+","+emp.getBonus()
					+",date_format('"
					+new Date(emp.getHiredate().getTime())
					+"','%X-%m-%d'),"+emp.getLeader()+","
					+emp.getDeptno()+")";//java.sql.Date(年月日)
			//打印:验证SQL语句正确性
			System.out.println("sql语句:"+sql);
			int i=st.executeUpdate(sql);//增加
			System.out.println("i值:"+i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4、关闭资源
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
			//1、加载驱动创建连接
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsd",
					"root", "1234");
			//2、创建语句对象
			st=con.createStatement();
			//3、执行SQL语句
			String sql="update emp_xu set ename='"
					+emp.getEname()+"',position='"
					+emp.getPosition()+"',salary="
					+emp.getSalary()+",bonus="+emp.getBonus()
					+",hiredate=date_format('"
					+new Date(emp.getHiredate().getTime())
					+"','%X-%m-%d'),leader="+emp.getLeader()
					+",deptno="+emp.getDeptno()
					+" where empno="+emp.getEmpno()+"";
			//打印
			System.out.println("sql语句:"+sql);
			st.executeUpdate(sql);//更新
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4、关闭资源
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
			//1、加载驱动创建连接
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/jsd",
					"root", "1234");
			//2、语句对象
			st=con.createStatement();
			//3、执行SQL语句
			String sql="delete from emp_xu where empno="+empno;
			st.executeUpdate(sql);//删除
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4、关闭资源
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






