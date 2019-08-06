package com.xms.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.entity.ExampleBean;
import com.xms.entity.User;

public class TestCase {

	//Spring容器实例化
	@Test
	public void testOne() {
		String xml = "spring.xml";
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(xml);
		
		System.out.println(ac);
		
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
	
	//Bean的作用域
	@Test
	public void testTwo() {
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("spring.xml");
		
		User one = (User)ac.getBean("user");
		User two = (User)ac.getBean("userOne");
		System.out.println(one == two);//false
		
		User three = (User)ac.getBean("userOne");
		System.out.println(two == three);//true
		//和上面的写法是一样的,不同的是通过反射的方式获取Bean对象,不用再进行数据类型的转换
		User four = ac.getBean("userTwo",User.class);
		User five = ac.getBean("userTwo",User.class);
		System.out.println(four == five);//false
	}
	
	//Bean的生命周期
	@Test
	public void testThree(){
		AbstractApplicationContext aac = 
			new ClassPathXmlApplicationContext("spring.xml");
		ExampleBean exampleBean = 
			aac.getBean("exampleBean",ExampleBean.class);
		
		System.out.println(exampleBean.getId());
		
		//关闭容器
		aac.close();
	}
	
}










