package com.xms.dao.impl;

import com.xms.dao.UserDao;
import com.xms.entity.User;
import com.xms.util.DButil;

import java.sql.*;

public class UserDaoImpe implements UserDao {
    User user = new User();
    @Override
    public void loginByStatement(String username, String pwd) {
        //Statement语句对象实现
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd","root","12345678");
            stmt = conn.createStatement();
            String sql = "select * from user_zhang where username='"+username+"' and password='"+pwd+"'";
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("登陆成功！");
            }else {
                System.out.println("登陆失败！");
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loginByPreparedStatement(String username, String pwd) {
        //PreparedStatement语句对象实现
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DButil.getConnection();
            String sql = "select * from user_zhang where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("登陆成功！");
            }else{
                System.out.println("登陆失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
