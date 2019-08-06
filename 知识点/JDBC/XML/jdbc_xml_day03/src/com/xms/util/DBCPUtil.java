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
 * ������
 * 1)��db.properties�ļ�������
 * 2)��װ���ӡ��رշ���
 * @author Administrator
 *
 */
public class DBCPUtil {
	//������������ļ�������
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	
	//���ļ�����
	private static Properties ps=new Properties();
	
	//�������ӳ�ʵ�ֶ���
	private static BasicDataSource ds=null;
	
	//��̬�����:�����ʱִ�в�ִֻ��һ��
	static {
		try {
			//���ļ�ȡ����
			ps.load(
			DBCPUtil.class.getClassLoader().
			getResourceAsStream("db.properties"));
			//ȡ����
			driver=ps.getProperty("mysql_driver");
			url=ps.getProperty("mysql_url");
			user=ps.getProperty("mysql_user");
			password=ps.getProperty("mysql_pwd");
			
			//ȡ���ӳ��������
			String initialSize=ps.getProperty("dataSource.initialSize");
			String maxIdle=ps.getProperty("dataSource.maxIdle");
			String minIdle=ps.getProperty("dataSource.minIdle");
			String maxActive=ps.getProperty("dataSource.maxActive");
			String maxWait=ps.getProperty("dataSource.maxWait");
			
			ds=new BasicDataSource();
			
			//���������ݿ�������õ��ö�����
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
			
			//�����ӳ���ز������õ��ö�����
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
				ds.setMaxWait(Long.parseLong(maxWait));//long����
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��װ���ӷ��� java.sql
	public static Connection getConnection() throws SQLException {
		Connection con=null;
		if(ds!=null) {
			con=ds.getConnection();
		}
		return con;
	}
	
	//��װ�黹����
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
			con.close();//���ӹ黹
		}
	}
}





