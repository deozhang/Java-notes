package mysql_JDBC.com.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
/**
 * Ϊʲôʹ�����ӳ�
 *	1�����ݿ�������һ����ʱ�Ĳ��������ӳؿ���ʹ�����������һ�����ӡ� 
	2�����ݿ����ӳصĻ���˼�����Ϊ���ݿ����ӽ���һ��������ء���
		Ԥ���ڻ�����з���һ�����������ӣ�
		����Ҫ�������ݿ�����ʱ��ֻ��ӡ�����ء���ȡ��һ����
		ʹ�����֮���ٷŻ�ȥ��
		���ǿ���ͨ���趨���ӳ��������������ֹϵͳ�޾��������ݿ����ӡ�
		��Ϊ��Ҫ�������ǿ���ͨ�����ӳصĹ������
		�������ݿ�����ӵ�������ʹ�������Ϊϵͳ���������Լ����ܵ����ṩ���ݡ� 
	3��ʹ�����ӳ���Ϊ����߶����ݿ�������Դ�Ĺ���
 *
 */
//�����ʹ�����ӳ�
public class Mydbcp1 {
	//����һ��DataSourceԴ��Ҳ��������
	static BasicDataSource bs = null;
	//properties���ϣ���ȡproperties�ļ�
	static Properties prop = new Properties();
	
	static {
		//��������������ļ������
		InputStream rs = Mydbcp1.class.getClassLoader().getResourceAsStream("dbcp.properties");
		try {
			//�����ļ��������ݵ�������
			prop.load(rs);
			//ͨ��basic�������DataSpurceԴ��Ҳ�����������൱��ע��
			bs = (BasicDataSource) BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
            // ����forѭ�����������Ƿ���ȷ
            for (int i = 0; i < 50; i++) {
                // �����ݳ���ȡ������
                Connection conn = bs.getConnection();
                System.out.println(conn.hashCode()+"...."+i);
               // System.out.println(bs.getMaxTotal());
                // ʹ����Ͻ����ӷŻ����ݳ�(�����Ǵ������close������������JDBCԭ����close)
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
