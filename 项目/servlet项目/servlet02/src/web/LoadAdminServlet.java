package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class LoadAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException, HTTPException{
		req.setCharacterEncoding("utf-8");
		
		res.setContentType("text/html;utf-8");
		
		PrintWriter out = res.getWriter();

		
		//查询数据
		Connection con = null;

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd?characterEncoding=UTF-8", "root","12345678");
		    int id = Integer.parseInt(req.getParameter("id"));
		    String sql = "select * from admin where id=?";
		    PreparedStatement ps = con.prepareStatement(sql);
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();

		    if(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String realname = rs.getString("realname");
				
				out.print("<form method='post' action='update'>");
				out.print("<input type='hidden' name='id' value='"+id+"'/>");//隐藏框
				out.print("nc<input name='username' value='"+username+"'/><br/>");
				out.print("mm<input name='password' value='"+password+"'/><br/>");
				out.print("xm<input name='realname' value='"+realname+"'/><br/>");
				out.print("<input type='submit' name='submit' value='Submit'>");
				out.print("</form>");
		    }
			
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
