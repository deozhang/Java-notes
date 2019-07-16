package com.xms.basic.day09;
/**
 * 访问控制权限符：
 * 		权限关系从大到的小的排序顺序如下：
 * 		public >protected >默认的（不写）>private
 * 	
 * 		使用范围如下：
 * 		public :在当前工程下都可以使用（本类，同包类，跨包类）
 * 		protected:本类，同包类，跨包子类（只能使用子类创建对象，进行调用）
 * 		默认的：本类，同包的类
 * 		private:本类
 * 		
 * 
 * 		--public 和private--常用
 * 		--修饰正常类：public和默认的
 * 		--内部类：protected和private居多（四个权限修饰都可以修饰内部类）
 * @author Administrator
 *
 */
public class Demo02 {
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void methodDemo02() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
	

}

































