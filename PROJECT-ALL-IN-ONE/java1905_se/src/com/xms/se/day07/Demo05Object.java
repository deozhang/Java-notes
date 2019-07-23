package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 第三组实现流:
 * 		对象流--高级流
 * 		ObjectInputStream:对象输入流
 * 			--readObject()
 * 		ObjectOutputStream:对象输出流
 * 			--writeObject()
 * 
 * 1.将特定结构的数据转成一组字节的过程--序列化
 * 2.将数据写入到物理内存中保存的过程--持久化
 * 3.将字节转成特定的结构数据的过程--反序列化
 * 
 * 序列化和反序列化作用:
 * 1.数据的传输
 * 2.数据的保存
 * 
 * {@link Serializable}可序列化的接口
 * 如果一个类的对象,想要进行序列化,该类需要实现可序列化的接口,
 * 此时该类的对象,才有资格进行序列化
 * java.io.NotSerializableException:未实现序列化的接口
 * 
 * transient:修饰成员变量,在序列化时忽略该成员变量的值
 * (没有将该数据保存到目标文件中 )
 * @author deo
 *
 */
public class Demo05Object {
	public static void method1() throws Throwable {
		/*
		 * 序列化
		 */
		//低级流
		FileOutputStream fos=new FileOutputStream("stu.txt");
		//高级流--对象流
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Student s=new Student("zd",18);
		/*
		 * writeObject(Object obj):
		 * 属于ObjectOutputStream类中的方法
		 * 该方法可以将给定的嗯对象转成一组字节写入到目标文件中
		 */
		oos.writeObject(s);
		oos.close();
		System.out.println("序列化完成");
	}
	public static void method2() throws Throwable {
		/*
		 * 反序列化
		 */
		//低级流
		FileInputStream fis=new FileInputStream("stu.txt");
		//高级流--对象流
		ObjectInputStream ois=new ObjectInputStream(fis);
		/*
		 * readObject():
		 * 属于ObjectInputStream类中的方法
		 * 该方法可以读取一个对象,返回值为Object类型的数据
		 * 
		 * 需要强制类型转换,才能获取对应对象的数据
		 */
		Object obj=ois.readObject();
		if(obj instanceof Student) {
			Student s=(Student)obj;
			System.out.println(s.name);
			System.out.println(s.age);
		}
		System.out.println(obj);
		ois.close();
		System.out.println("反序列化完成");
	}
	
	
	public static void main(String[] args) throws Throwable {
//		method1();
		method2();
	}
}
//学生类
class Student implements Serializable{
	/**
	 * 版本号:IDE自动生成
	 * 防止在序列化后,反序列化前,增加类的内容,出现异常,使用IDE自动生成
	 * 序列化的版本号
	 * 
	 * 需要在序列化之前加入版本号
	 */
	private static final long serialVersionUID = 1L;
	String name;
	transient int age;//在序列化时忽略该成员变量的值
	char sex;//新增
	public Student() {
		
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
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}	
}