package mysql_JDBC.com.Test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

//Ӳ����ʹ�����ӳ�
//���ַ����Ƚ��鷳����Ҫһ��һ�����������ã�Զ����properties�����ļ����㣬
//������ϻ��ߣ����Ƽ�ʹ��
public class Mydbcp2 {
	//����DBCP
	static BasicDataSource bds = new BasicDataSource();
	
	static {
		bds.setDriverClassName("com.mysql.jdbc.Driver");;
		bds.setUrl("jdbc:mysql://localhost:3306/test");
		bds.setUsername("root");
		bds.setPassword("1234");
		
		bds.setInitialSize(6);//��ʼ�����ӳ�ӵ�е���������
		bds.setMaxIdle(20);//�����еȴ�
		bds.setMinIdle(20);//��С���еȴ�
		bds.setMaxWait(10000);//���ȴ�ʱ��	
	}
	
	public static void main(String[] args) {
			//forѭ�����������Ƿ�ɹ�
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

