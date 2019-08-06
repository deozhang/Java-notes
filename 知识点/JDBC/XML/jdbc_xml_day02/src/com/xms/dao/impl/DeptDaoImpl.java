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
 * 实现类
 * @author Administrator
 *
 */
public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> findAll() {
		Connection con=null;//java.sql
		Statement st=null;
		ResultSet rs=null;
		//集合
		List<Dept> depts=new ArrayList<Dept>();
		
		try {
			//1、通过工具类获取连接
			con=DBUtil.getConnection();
			//2、语句对象
			st=con.createStatement();
			//3、执行SQL语句
			String sql="select * from dept_xu";
			rs=st.executeQuery(sql);//查询
			//4、处理结果集
			Dept dept=null;
			while(rs.next()) {
				dept=new Dept();
				//取数据给对象赋值
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLocation(rs.getString("location"));
				//将对象添加到集合
				depts.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//5、关闭资源
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
		//对象
		Dept dept=null;
		
		try {
			//1、连接
			con=DBUtil.getConnection();
			//2、语句对象
			st=con.createStatement();
			//3、执行
			String sql="select * from dept_xu where deptno="+deptno;
			rs=st.executeQuery(sql);//查询
			//4、处理结果集
			if(rs.next()) {
				dept=new Dept();
				//取数据给对象赋值
				//rs.getXXX(字段名|数字)
				dept.setDeptno(rs.getInt(1));
				dept.setDname(rs.getString(2));
				dept.setLocation(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//5、关闭资源
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
			//1、连接
			con=DBUtil.getConnection();
			//2、语句对象
			st=con.createStatement();
			//3、执行
			String sql="insert into dept_xu values("
					+dept.getDeptno()+",'"+dept.getDname()
					+"','"+dept.getLocation()+"')";
			//打印
			System.out.println("sql语句:"+sql);
			st.executeUpdate(sql);//增加
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4、关闭资源
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
			//1、连接
			con=DBUtil.getConnection();
			//2、语句对象
			st=con.createStatement();
			//3、执行
			String sql="update dept_xu set dname='"
					+dept.getDname()+"',location='"
					+dept.getLocation()+"' where deptno="
					+dept.getDeptno()+"";
			//打印
			System.out.println("sql语句:"+sql);
			st.executeUpdate(sql);//更新
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//4、关闭资源
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
