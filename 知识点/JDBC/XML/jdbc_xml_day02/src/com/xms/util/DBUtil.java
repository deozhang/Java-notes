package com.xms.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类
 * 1)读db.properties文件中数据
 * 2)封装连接、关闭方法
 * @author Administrator
 *
 */
public class DBUtil {
	//定义变量接收文件的数据
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	
	//读文件对象
	private static Properties ps=new Properties();
	
	//静态代码块:类加载时执行并只执行一次
	static {
		try {
			//读文件取数据
			ps.load(
			DBUtil.class.getClassLoader().
			getResourceAsStream("db.properties"));
			//取数据
			driver=ps.getProperty("mysql_driver");
			url=ps.getProperty("mysql_url");
			user=ps.getProperty("mysql_user");
			password=ps.getProperty("mysql_pwd");
			//加载驱动
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//封装连接方法 java.sql
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	//封装关闭方法
	public static void closeConnection(
			Connection con,Statement st,ResultSet rs) 
					throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(con!=null) {
			con.close();
		}
	}
}





