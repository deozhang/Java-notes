package com.xms.dao.impl;

import com.xms.dao.EmpDao;
import com.xms.entity.Emp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> findAll() {
        //集合：存放多个对象
        List<Emp> emps = new ArrayList<Emp>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        //1.加载驱动创建连接
        //通过反射机制实例化Driver驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","12345678");
        //2.创建语句对象
        st = con.createStatement();
        //3.执行SQL语句
        String sql = "select * from emp_zhang";
        rs = st.executeQuery(sql);
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
                if(rs!=null){
                    rs.close();
                }
                if(st!=null){
                    st.close();
                }
                if(con!=null){
                    st.close();
                }
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
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jsd?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root","12345678");
            stmt = conn.createStatement();
            String QueryNameString = "select * from emp_zhang where empno="+empno;
            rs = stmt.executeQuery(QueryNameString);
        } catch (Exception e) {
            e.printStackTrace();
        }
            Emp emp1 = null;
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
           try{
               if(rs!=null){
                   rs.close();
               }
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

        return emp;
    }

    @Override
    public void insertEmp(Emp emp) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd","root","12345678");
            stmt = conn.createStatement();
            //格式"++"    '"++"'
            //sql语句换行使光标要放在+号前面
            //Date要导sql的包
            String sql = "insert into emp_zhang values(" + ""+emp.getEmpno()+",'"
                    +emp.getEname()+"','"+emp.getPosition()+"'," + ""+emp.getSalary()+","
                    +emp.getBonus()+","
                    + "date_format('"+new Date(emp.getHiredate().getTime())+"','%X-%m-%d'),"
                    +emp.getLeader()+"," + "" + ""+emp.getDeptno()+")";
            //执行前打印，验证SQL语句的正确性
            System.out.println("sql语句："+sql);
            int i = stmt.executeUpdate(sql);
            System.out.println("i值:"+i);
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

    @Override
    public void updateEmp(Emp emp) {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd","root","12345678");
                    stmt = con.createStatement();
        String sql = "update emp_zhang set ename='"
                +emp.getEname()+"',position='"+emp.getPosition()
                +"',salary="+emp.getSalary()+",bonus="+emp.getBonus()
                +",hiredate=date_format('" +new Date(emp.getHiredate().getTime())
                +"','%X-%m-%d'),leader="+emp.getLeader()+",deptno="+emp.getDeptno()
                +" where empno="+emp.getEmpno()+"";
        //打印
        System.out.println("sql语句："+sql);
        stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null){
                    stmt.close();
                }
                if(con!=null){
                    con.close();
                }
            }catch (SQLException e){
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
