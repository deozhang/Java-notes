package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class AddAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) 
		throws IOException,HTTPException{
		//设置服务器解码格式为utf-8
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		//获取表单数据
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String realname = req.getParameter("realname");
		//入库
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd?characterEncoding=UTF-8","root","12345678");
			String sql = "insert into admin values (null,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, realname);
			ps.execute();
			//提示用户
			out.print("添加成功");
			out.print("<br/><a href='list'>查看列表</a>");
			
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



