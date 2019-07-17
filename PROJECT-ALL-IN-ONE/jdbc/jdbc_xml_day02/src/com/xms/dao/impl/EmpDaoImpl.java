package com.xms.dao.impl;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;
import com.xms.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> findAll() {
        //集合：存放多个对象
        List<Emp> emps = new ArrayList<Emp>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //1.加载驱动创建连接
        //通过反射机制实例化Driver驱动类
        try {
            con = DButil.getConnection();
        //2.创建语句对象
            //创建语句对象时需要一条预编译的SQL语句
            String sql = "select * from emp_zhang";
            ps = con.prepareStatement(sql);
        //3.执行SQL语句
        rs = ps.executeQuery();//不需要参数
        //4.处理结果集
        Emp emp = null;

        while(rs.next()){
            //有数据
            //封装一个对象
            emp = new Emp();
            //给对象赋值
            emp.setEmpno(rs.getInt("empno"));
            emp.setEname(rs.getString("ename"));
            emp.setPosition(rs.getString("position"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setBonus(rs.getDouble("bonus"));
            emp.setHiredate(rs.getDate("hiredate"));
            emp.setLeader(rs.getInt("leader"));
            emp.setDeptno(rs.getInt("deptno"));
            //把对象添加到集合
            emps.add(emp);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.关闭资源
            try {
               DButil.closeConnection(con,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emps;
    }
    Emp emp = new Emp();
    @Override
    public Emp findByEmpno(int empno) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DButil.getConnection();
            //创建语句对象需要预编译SQL语句，SQL语句中需要参数的地方用英文的问号作为占位符
            String sql = "select * from emp_zhang where empno=?";
            ps = conn.prepareStatement(sql);
            //语句执行之前必须给问号赋值
            //ps.setXXX(问号的下标,问号的值)：下标从1开始
            ps.setInt(1,empno);
            //执行
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
            Emp emp = null;
        try {
            while (rs.next()){
                emp = new Emp();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setPosition(rs.getString(3));
                emp.setSalary(rs.getDouble(4));
                emp.setBonus(rs.getDouble(5));
                emp.setHiredate(rs.getDate(6));
                emp.setLeader(rs.getInt(7));
                emp.setDeptno(rs.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DButil.closeConnection(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emp;
    }

    @Override
    public void insertEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DButil.getConnection();
            //格式"++"    '"++"'
            //sql语句换行使光标要放在+号前面
            //Date要导sql的包
            String sql = "insert into emp_zhang values(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //给问号赋值
            ps.setInt(1,emp.getEmpno());
            ps.setString(2,emp.getEname());
            ps.setString(3,emp.getPosition());
            ps.setDouble(4,emp.getSalary());
            ps.setDouble(5,emp.getBonus());
            ps.setDate(6,new Date(emp.getHiredate().getTime()));
            ps.setInt(7,emp.getLeader());
            ps.setInt(8,emp.getDeptno());
            int i = ps.executeUpdate();
            System.out.println("i值:"+i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DButil.closeConnection(conn,ps,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void updateEmp(Emp emp) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DButil.getConnection();
        String sql = "update emp_zhang set ename=?,position =?,salary=?,bonus=?,hiredate=?,leader=?,deptno=? where empno=?";
        //给问号赋值
        ps.setString(1,emp.getEname());
        ps.setString(2,emp.getPosition());
        ps.setDouble(3,emp.getSalary());
        ps.setDouble(4,emp.getBonus());
        ps.setDate(5,new Date(emp.getHiredate().getTime()));
        ps.setInt(6,emp.getLeader());
        ps.setInt(7,emp.getDeptno());
        ps.setInt(8,emp.getEmpno());
        ps.executeUpdate();//更新，不需要参数
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DButil.closeConnection(con,ps,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteEmp(int empno) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd","root","12345678");
            String sql="delete from emp_zhang where empno="+empno;
            System.out.println("sql语句为："+sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null){
                    stmt.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
