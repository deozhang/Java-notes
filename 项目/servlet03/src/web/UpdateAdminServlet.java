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

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;
import factory.DAOFactory;

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

		try {
			AdminDAO dao = (AdminDAO) DAOFactory.getInstance("AdminDAO");
		    Admin admin = new Admin(id,username,password,realname);
		    dao.update(admin);
			res.sendRedirect("list");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}


}
