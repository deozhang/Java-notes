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

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;
import factory.DAOFactory;

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

		try {
			AdminDAO dao = (AdminDAO) DAOFactory.getInstance("AdminDAO");
			Admin admin = new Admin(username,password,realname);
			dao.add(admin);
			//提示用户
			out.print("添加成功");
			out.print("<br/><a href='list'>查看列表</a>");
			
			res.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



