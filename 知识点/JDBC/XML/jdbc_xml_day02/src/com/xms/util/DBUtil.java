package com.xms.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ������
 * 1)��db.properties�ļ�������
 * 2)��װ���ӡ��رշ���
 * @author Administrator
 *
 */
public class DBUtil {
	//������������ļ�������
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	
	//���ļ�����
	private static Properties ps=new Properties();
	
	//��̬�����:�����ʱִ�в�ִֻ��һ��
	static {
		try {
			//���ļ�ȡ����
			ps.load(
			DBUtil.class.getClassLoader().
			getResourceAsStream("db.properties"));
			//ȡ����
			driver=ps.getProperty("mysql_driver");
			url=ps.getProperty("mysql_url");
			user=ps.getProperty("mysql_user");
			password=ps.getProperty("mysql_pwd");
			//��������
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��װ���ӷ��� java.sql
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	//��װ�رշ���
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





