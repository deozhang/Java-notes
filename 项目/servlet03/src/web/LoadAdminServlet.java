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

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

public class LoadAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException, HTTPException{
		req.setCharacterEncoding("utf-8");
		
		res.setContentType("text/html;utf-8");
		
		PrintWriter out = res.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			AdminDAO dao = new AdminDAOImpl();
			Admin admin = dao.findById(id);
				
		    if(admin!=null) {
				String username = admin.getUsername();
				String password = admin.getPassword();
				String realname = admin.getRealname();
				
				out.print("<form method='post' action='update'>");
				out.print("<input type='hidden' name='id' value='"+id+"'/>");//隐藏框
				out.print("昵称<input name='username' value='"+username+"'/><br/>");
				out.print("密码<input name='password' value='"+password+"'/><br/>");
				out.print("姓名<input name='realname' value='"+realname+"'/><br/>");
				out.print("<input type='submit' name='submit' value='Submit'>");
				out.print("</form>");
		    }
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

}
