package com.xms.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}










