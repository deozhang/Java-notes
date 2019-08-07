package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class UpdateAdminServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException,HTTPException{
		req.setCharacterEncoding("utf-8");
		
		res.setContentType("text/html;utf-8");
		PrintWriter out = res.getWriter();
		
		//获取表单数据
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String realname = req.getParameter("realname");
		
		//查询数据
		Connection con = null;

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd?characterEncoding=UTF-8", "root","12345678");
		    String sql = "update admin set username=?,password=?,realname=? where id=?";
		    PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, realname);
			ps.setInt(4, id);
			System.out.println(sql);
			ps.executeUpdate();
			
			res.sendRedirect("list");
		} catch (Exception e) {
		    e.printStackTrace();
		}finally {
		    if(con!=null) {
		        try {
		            con.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}
	}


}
