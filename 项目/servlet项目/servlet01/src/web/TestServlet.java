package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//获取表单参数 服务器解码格式ISO0859-1
		//设置服务器端的解码格式为utf-8,只对post有效
		req.setCharacterEncoding("utf-8");
//		res.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("age"));
		String[] interest = req.getParameterValues("interest");
		
		//设置相应消息头
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		out.print(username+","+age+","+Arrays.toString(interest));
	}

}
