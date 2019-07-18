package com.xms.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;
import java.util.Properties;

/**
 * Util Class
 * 1.read data from db.properties file
 * 2.encapsulation connection, close method
 */
public class DBCPUtil {
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    //读文件对象
    private static Properties ps = new Properties();

    //定义连接池实现对象
    private static BasicDataSource ds=null;

    //static code block
    static {
        try {
            ps.load(DBCPUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            driver = ps.getProperty("mysqlDriver");
            url = ps.getProperty("mysqlUrl");
            user = ps.getProperty("mysqlUser");
            password = ps.getProperty("mysqlPwd");

            //取连接池相关数据
            String initialSize=ps.getProperty("dataSource.initialSize");
            String maxIdle=ps.getProperty("dataSource.maxIdle");
            String minIdle=ps.getProperty("dateSource.minIdle");
            String maxActive=ps.getProperty("dataSource.maxActive");
            String maxWait=ps.getProperty("dataSource.maxWait");

            ds = new BasicDataSource();

            //将连接数据库参数设置到该对象中
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(user);
            ds.setPassword(password);
            //将连接池相关参数设置到该对象中
            if (initialSize!=null){
                ds.setInitialSize(Integer.parseInt(initialSize));
            }
            if (maxIdle!=null){
                ds.setMaxIdle(Integer.parseInt(maxIdle));
            }
            if (minIdle!=null){
                ds.setMinIdle(Integer.parseInt(minIdle));
            }
            if(maxActive!=null){
                ds.setMaxIdle(Integer.parseInt(maxActive));
            }
            if (maxWait!=null){
                ds.setMaxWait(Long.parseLong(maxWait));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // encapsulation connection method  ()
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        if (ds!=null){
            conn = ds.getConnection();
        }
        return conn;
    }
    //encapsulation 归还方法
    public static void releaseConnection(
            Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs!=null){
            rs.close();
        }
        if (stmt!=null){
            stmt.close();
        }
        if (conn!=null){
            conn.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
