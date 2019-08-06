package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		Date date = new Date();
		//获取字符输出流
		PrintWriter out = res.getWriter();
		out.print(date);
	}
}
