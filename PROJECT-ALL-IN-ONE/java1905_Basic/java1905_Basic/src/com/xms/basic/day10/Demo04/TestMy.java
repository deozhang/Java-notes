package com.xms.basic.day10.Demo04;
/**
 * 
 * @author Administrator
 *
 */
public class TestMy {
	//匿名内部类
	InterFace my1=new InterFace() {
		public void add() {
			System.out.println("加法");
		}
	};
	public static void main(String[] args) {
		InterFace my=new My();
		my.add();
		
		//局部匿名内部类--重要
		InterFace my2=new InterFace() {
			public void add() {
				System.out.println("加法");
			}
		};
		my2.add();
	}

}
