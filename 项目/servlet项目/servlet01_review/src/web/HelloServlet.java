package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class HelloServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException,HTTPException{
		//设置消息头
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		out.print("你好啊,帝哥哥~");
		
	}
}
