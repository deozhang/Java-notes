package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class DelAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException,HTTPException{
		//获取请求参数id值
		//jdbc删表记录
		//重定向到列表页面
		int id = Integer.parseInt(req.getParameter("id"));
		//查询数据
		Connection con = null;

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd", "root","12345678");
		    String sql = "delete from admin where id=?";
		    PreparedStatement ps = con.prepareStatement(sql);
		    ps.setInt(1, id);
		    ps.executeUpdate();
		    res.sendRedirect("list");
		} catch (Exception e) {
		    e.printStackTrace();
		}finally {
		    if(con!=null) {
		        try {
		            con.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
}
