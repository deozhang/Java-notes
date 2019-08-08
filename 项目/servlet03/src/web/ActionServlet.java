package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import dao.AdminDAO;
import entity.Admin;
import factory.DAOFactory;

public class ActionServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException,HTTPException{
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		//获取请求资源路径
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		AdminDAO dao = (AdminDAO) DAOFactory.getInstance("AdminDAO");
		
		if("/list".equals(action)) {
			//查询数据
			
			try {
				List<Admin> list = dao.findAll();
				out.print("<table border='1px'>");
				out.print("<tr><td>序号</td><td>昵称</td><td>密码</td><td>姓名</td><td>删除 修改</td></tr>");
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
							+ "<td><a href='del.do?id="+id+"'>删除</a>"
							+ "&nbsp;<a href='load.do?id="+id+"'>修改</a></td>"
							+ "</tr>");
				}
				out.print("</table>");
				out.print("<a href='add.html'>添加管理员</a>");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/del".equals(action)) {
			int id = Integer.parseInt(req.getParameter("id"));

			try {
				dao.del(id);
			    res.sendRedirect("list.do");
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}else if("/add".equals(action)) {
			//获取表单数据
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String realname = req.getParameter("realname");

			try {
				Admin admin = new Admin(username,password,realname);
				dao.add(admin);
				//提示用户
				out.print("添加成功");
				out.print("<br/><a href='list.do'>查看列表</a>");
				
				res.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/load".equals(action)) {
			int id = Integer.parseInt(req.getParameter("id"));
			
			try {
				Admin admin = dao.findById(id);
					
			    if(admin!=null) {
					String username = admin.getUsername();
					String password = admin.getPassword();
					String realname = admin.getRealname();
					
					out.print("<form method='post' action='update.do'>");
					out.print("<input type='hidden' name='id' value='"+id+"'/>");//隐藏框
					out.print("昵称<input name='username' value='"+username+"'/><br/>");
					out.print("密码<input name='password' value='"+password+"'/><br/>");
					out.print("姓名<input name='realname' value='"+realname+"'/><br/>");
					out.print("<input type='submit' name='submit' value='提交'>");
					out.print("</form>");
			    }
				
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
		}else if("/update".equals(action)) {
			//获取表单数据
			int id = Integer.parseInt(req.getParameter("id"));
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String realname = req.getParameter("realname");

			try {
			    Admin admin = new Admin(id,username,password,realname);
			    dao.update(admin);
				res.sendRedirect("list.do");
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
	}
}
