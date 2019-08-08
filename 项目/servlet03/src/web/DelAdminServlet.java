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

import dao.AdminDAO;
import dao.AdminDAOImpl;
import factory.DAOFactory;

public class DelAdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException,HTTPException{
		//获取请求参数id值
		//jdbc删表记录
		//重定向到列表页面
		int id = Integer.parseInt(req.getParameter("id"));

		try {
			AdminDAO dao = (AdminDAO) DAOFactory.getInstance("AdminDAO");
			dao.del(id);
		    res.sendRedirect("list");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
