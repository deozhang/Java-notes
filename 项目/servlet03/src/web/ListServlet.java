package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysql.jdbc.Driver;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entity.Admin;

public class ListServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException,HTTPException{
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//查询数据
		
		try {
			AdminDAO dao = new AdminDAOImpl();
			List<Admin> list = dao.findAll();
			out.print("<table border='1px'>");
			out.print("<tr><td>序号</td><td>昵称</td><td>密码</td><td>姓名</td><td>删除</td></tr>");
			int count = 1;
			for(Admin admin:list){
				int id = admin.getId();
				String username = admin.getUsername();
				String password = admin.getPassword();
				String realname = admin.getRealname();
				out.print("<tr>"
						+ "<td>"+(count++)+"</td>"
						+ "<td>"+username+"</td>"
						+ "<td>"+password+"</td>"
						+ "<td>"+realname+"</td>"
						+ "<td><a href='del?id="+id+"'>删除</a>"
						+ "&nbsp;<a href='load?id="+id+"'>修改</a></td>"
						+ "</tr>");
			}
			out.print("</table>");
			out.print("<a href='add.html'>添加管理员</a>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
