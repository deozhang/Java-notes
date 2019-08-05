package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	//重写service
	/**
	 * HttpServletRequest:请求对象
	 * HttpServletResponse:相应对象
	 */
	public void service(HttpServletRequest req,HttpServletResponse res) 
			throws IOException,ServletException {
		//向页面输出hello servlet
		//设置相应消息头(写在获取字符输出流前面)
		//服务器默认编码格式ISO8859-1,浏览器默认gbk
		/**
		 * charset=utf-8
		 * 作用1:设置服务器的编码格式utf-8
		 * 作用2:设置浏览器的解码格式为utf-8
		 */
		res.setContentType("text/html;charset=utf-8");
		//获取请求参数值
		String name = req.getParameter("name");
		String city[] = req.getParameterValues("city");
		//获取字符输出流
		PrintWriter out = res.getWriter();
		out.print("<span style='color:red;'>你好来自"+Arrays.toString(city)+""+name+"</span>");
		//关闭流(调用完成后会自动关闭,可以不写)
		out.close();
		
	}
}
