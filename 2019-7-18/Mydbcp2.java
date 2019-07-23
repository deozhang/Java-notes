package mysql_JDBC.com.Test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

//硬编码使用连接池
//这种方法比较麻烦，需要一步一步的设置配置，远不如properties配置文件方便，
//而且耦合还高，不推荐使用
public class Mydbcp2 {
	//声明DBCP
	static BasicDataSource bds = new BasicDataSource();
	
	static {
		bds.setDriverClassName("com.mysql.jdbc.Driver");;
		bds.setUrl("jdbc:mysql://localhost:3306/test");
		bds.setUsername("root");
		bds.setPassword("1234");
		
		bds.setInitialSize(6);//初始化连接池拥有的链接数量
		bds.setMaxIdle(20);//最大空闲等待
		bds.setMinIdle(20);//最小空闲等待
		bds.setMaxWait(10000);//最大等待时间	
	}
	
	public static void main(String[] args) {
			//for循环测试连接是否成功
			try {
				for(int i = 0;i<50;i++) {
					Connection conn;
					conn = bds.getConnection();
					System.out.println(conn.hashCode()+"...."+i);
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}

