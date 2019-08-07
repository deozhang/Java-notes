package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	
	//获取连接
	public static Connection getConnection() {
		//查询数据
		Connection con = null;

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd?characterEncoding=UTF-8", "root","12345678");
		    String sql = "select * from admin";
		    PreparedStatement ps = con.prepareStatement(sql);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return con;
	}
	//释放连接
	public static void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
