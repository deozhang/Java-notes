package com.xms.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 工具类
 * 1)读db.properties文件中数据
 * 2)封装连接、关闭方法
 * @author Administrator
 *
 */
public class DBCPUtil {
	//定义变量接收文件的数据
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	
	//读文件对象
	private static Properties ps=new Properties();
	
	//定义连接池实现对象
	private static BasicDataSource ds=null;
	
	//静态代码块:类加载时执行并只执行一次
	static {
		try {
			//读文件取数据
			ps.load(
			DBCPUtil.class.getClassLoader().
			getResourceAsStream("db.properties"));
			//取数据
			driver=ps.getProperty("mysql_driver");
			url=ps.getProperty("mysql_url");
			user=ps.getProperty("mysql_user");
			password=ps.getProperty("mysql_pwd");
			
			//取连接池相关数据
			String initialSize=ps.getProperty("dataSource.initialSize");
			String maxIdle=ps.getProperty("dataSource.maxIdle");
			String minIdle=ps.getProperty("dataSource.minIdle");
			String maxActive=ps.getProperty("dataSource.maxActive");
			String maxWait=ps.getProperty("dataSource.maxWait");
			
			ds=new BasicDataSource();
			
			//将连接数据库参数设置到该对象中
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
			
			//将连接池相关参数设置到该对象中
			if(initialSize!=null) {
				ds.setInitialSize(Integer.parseInt(initialSize));
			}
			
			if(maxIdle!=null) {
				ds.setMaxIdle(Integer.parseInt(maxIdle));
			}
			
			if(minIdle!=null) {
				ds.setMinIdle(Integer.parseInt(minIdle));
			}
			
			if(maxActive!=null) {
				ds.setMaxActive(Integer.parseInt(maxActive));
			}
			
			if(maxWait!=null) {
				ds.setMaxWait(Long.parseLong(maxWait));//long类型
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//封装连接方法 java.sql
	public static Connection getConnection() throws SQLException {
		Connection con=null;
		if(ds!=null) {
			con=ds.getConnection();
		}
		return con;
	}
	
	//封装归还方法
	public static void releaseConnection(
			Connection con,Statement st,ResultSet rs) 
					throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(con!=null) {
			con.close();//连接归还
		}
	}
}





