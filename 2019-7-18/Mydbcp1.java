package mysql_JDBC.com.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
/**
 * 为什么使用连接池
 *	1。数据库连接是一件费时的操作，连接池可以使多个操作共享一个连接。 
	2。数据库连接池的基本思想就是为数据库连接建立一个“缓冲池”。
		预先在缓冲池中放入一定数量的连接，
		当需要建立数据库连接时，只需从“缓冲池”中取出一个，
		使用完毕之后再放回去。
		我们可以通过设定连接池最大连接数来防止系统无尽的与数据库连接。
		更为重要的是我们可以通过连接池的管理机制
		监视数据库的连接的数量、使用情况，为系统开发，测试及性能调整提供依据。 
	3。使用连接池是为了提高对数据库连接资源的管理
 *
 */
//软编码使用连接池
public class Mydbcp1 {
	//声明一个DataSource源，也就是驱动
	static BasicDataSource bs = null;
	//properties集合，读取properties文件
	static Properties prop = new Properties();
	
	static {
		//用类加载器加载文件获得流
		InputStream rs = Mydbcp1.class.getClassLoader().getResourceAsStream("dbcp.properties");
		try {
			//加载文件配置内容到集合中
			prop.load(rs);
			//通过basic工厂获得DataSpurce源，也就是驱动，相当于注册
			bs = (BasicDataSource) BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
            // 来个for循环测试配置是否正确
            for (int i = 0; i < 50; i++) {
                // 从数据池中取出连接
                Connection conn = bs.getConnection();
                System.out.println(conn.hashCode()+"...."+i);
               // System.out.println(bs.getMaxTotal());
                // 使用完毕将连接放回数据池(这里是代理过的close方法，并不是JDBC原生的close)
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
