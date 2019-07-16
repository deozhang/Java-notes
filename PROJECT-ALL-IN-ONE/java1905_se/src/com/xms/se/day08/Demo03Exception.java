package com.xms.se.day08;
/**
 * 	抛出：throws	在方法上声明，提示调用者，该方法可能会出现异常，
 * 	让调用者进行处理，处理方法：
 * 		1.捕获
 * 		2.抛出
 * 	throw：自定义异常
 * @author deo
 *
 */
public class Demo03Exception {
	public void method1() throws Exception {
		Student s=new Student();
		s.setAge(80);
		System.out.println(s.getAge());
	}
	public static void main(String[] args) {
		Demo03Exception de=new Demo03Exception();
		try {
			de.method1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//学生类
class Student{
	private String name;
	private int age;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		if(age<=0||age>=160) {
			/*
			 * 	RuntimeException:
			 *	虚拟机默认这些异常对于程序员来说是常识性的
			 *	不需要提示。
			 */
			throw new RuntimeException("年龄超出正常范围");
		}
		this.age = age;
	}
	
}














