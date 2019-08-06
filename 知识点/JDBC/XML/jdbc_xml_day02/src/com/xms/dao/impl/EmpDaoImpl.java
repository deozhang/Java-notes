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
 * 实现类
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		Connection con=null;
		PreparedStatement ps=null;//java.sql
		ResultSet rs=null;
		//集合:存放多个对象
		List<Emp> emps=new ArrayList<Emp>();
		
		try {
			//1、连接
			con=DBUtil.getConnection();
			//2、创建语句对象
			//创建语句对象时需要一条预编译的SQL语句
			String sql="select * from emp_xu";
			ps=con.prepareStatement(sql);
			//3、执行SQL语句
			rs=ps.executeQuery();//查询 方法不需要参数
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
		//对象
		Emp emp=null;
		try {
			//1、连接
			con=DBUtil.getConnection();
			//2、创建语句对象
			//创建语句对象需要预编译SQL语句，SQL语句中需要参数的
			//地方用问号(必须英文状态下的)作为占位符
			String sql="select * from emp_xu where empno=?";
			ps=con.prepareStatement(sql);
			//3、执行SQL语句
			//语句执行之前必须给问号赋值
			//ps.setXXX(问号的下标,问号的值):下标从1开始
			ps.setInt(1, empno);
			//执行
			rs=ps.executeQuery();//查询 方法不需要参数
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
			//1、连接
			con=DBUtil.getConnection();
			//2、创建语句对象
			String sql="insert into emp_xu values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			//3、执行SQL语句
			//给问号赋值
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getPosition());
			ps.setDouble(4, emp.getSalary());
			ps.setDouble(5, emp.getBonus());
			//java.util.Date->java.sql.Date
			ps.setDate(6,new Date(emp.getHiredate().getTime()) );
			ps.setInt(7, emp.getLeader());
			ps.setInt(8, emp.getDeptno());
			//执行
			ps.executeUpdate();//增加 不需要参数
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4、关闭资源
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
			//1加载驱动创建连接
			con=DBUtil.getConnection();
			//2、创建语句对象
			String sql="update emp_xu set ename=?,position=?,salary=?,bonus=?,hiredate=?,leader=?,deptno=? where empno=?";
			ps=con.prepareStatement(sql);
			//3、执行SQL语句
			//给问号赋值
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getPosition());
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getBonus());
			//java.sql.Date
			ps.setDate(5, new Date(emp.getHiredate().getTime()));
			ps.setInt(6, emp.getLeader());
			ps.setInt(7, emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			//执行
			ps.executeUpdate();//更新 不需要参数
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4、关闭资源
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






