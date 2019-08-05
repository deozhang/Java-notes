居律 qq:708967012

服务器端编程:

-----

1.什么是B/S结构应用

	客户端采用的是标准的浏览器,服务器端采用的是标准的web服务器,客户端与服务器端采用的是标准的HTTP协议进行通讯
	
	相对于C/S,B/S结构的优点:
	a.编程相对简单,不需要编写通讯模块与自定义协议
	b.不需要用户手动安装,并且,后期版本升级时,也不需要用户手动更新

2.TOMCAT容器

3.什么是servlet?
	sun公司制定的一种用于拓展web服务器功能的组件规范
	
	拓展web服务器功能?
		因为早期的web服务器只能处理静态资源文件,不能处理动态资源文件(需要经过一系列计		 算生成的页面,所以需要拓展)

	扩展方式:
	组件+容器
	组件:符合规范,实现特定功能的软件模块(Java类,需要程序员编写)
	容器:符号规范,为组件提供运行环境,并管理组件生命周期的软件程序
	
4.使用servlet编写web应用步骤(web版本3.0版本后采用注解的方式,之前用的是XML的格式)
	1.定义Java类,继承HttpServlet
	2.重写service方法
	3.在web.xml文件中配置servlet组件
	
5.http://localhost:8080/servlet01/sayHello
	a.根据IP:端口号确定访问的服务
	b.根据servlet01查找webapps目录下对应的文件夹
	c.根据/sayHello匹配web.xml文件中的
	d.如果匹配成功,根据servlet-name查找servlet-class
	<!-- 类路径 web.HelloServlet -->
	e.Tomcat容器利用反射的技术实例化servlet组件对象,调用service方法处理请求

练习L写一个DateServlet,访问当前时间
localhost:8080/servlet01/date
now:2019-08-05 15:10:00

6.servlet中如何正确输出中文?
	编码格式与解码格式应保持一致
	response.setContentType("text/html;charset=utf-8");
	printWriter out = response.getWriter();
	
7.servlet中获取请求参数值?
	参数名唯一:
	String:request.getParameter("参数名");
	参数名不唯一:
	String[]:request.getParameterValues("参数名");
	注意:参数名若写错,返回null
