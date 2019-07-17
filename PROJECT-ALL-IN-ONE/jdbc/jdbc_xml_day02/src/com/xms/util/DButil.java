package com.xms.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Util Class
 * 1.read data from db.properties file
 * 2.encapsulation connection, close method
 */
public class DButil {
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    private static Properties ps = new Properties();

    //static code block
    static {
        try {
            ps.load(DButil.class.getClassLoader().
                    getResourceAsStream("db.properties"));
            driver = ps.getProperty("mysqlDriver");
            url = ps.getProperty("mysqlUrl");
            user = ps.getProperty("mysqlUser");
            password = ps.getProperty("mysqlPwd");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // encapsulation connection method  ()
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    //encapsulation close method
    public static void closeConnection(
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
}
