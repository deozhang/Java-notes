package com.xms.se.day02;
/**
 * Object是所有引用类型的顶级父类（包装类部分除外）
 * 该变量的引用变量可以指向任何类型的对象
 * 没有成员变量  仅有部分方法
 * --toString():描述一个类或一个对象的信息的方法，只是作为展示数据使用
 * 重写：根据业务需求重写内容  后期作为一个比较常用的调试工具
 * --equals():比较各个类型的两个对象内容是否相同
 * 		各个类型的对象时可以相互比较，但是一般来说，我们会根据实际情况，讨论两个相同类型的不同对象
 * 		比较的情况
 * 
 * 		重写：两个同一类型的不同对象的某些属性值相同
 * 				可以认为这两个对象“相同”
 *  
 * 
 *
 * 面向对象:
 * 
 * 
 * @author Administrator
 *
 */
public class Demo05Object {
	public static void main(String args[]) {
		Student st1=new Student("xiaohong",15,2422);
		Student st2=new Student("xiaohong",15,2422);
		System.out.println(st1.toString());
	}
	

}
//学生类
class Student{
	String name;
	int age;
	int id;
	public Student() {
		
	}
	
	public Student(String name,int age,int id) {
		this.name=name;
		this.age=age;
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "name:"+name+",age:"+age+",id:"+id;
	}
}