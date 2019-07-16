package com.xms.basic.day10.Demo03;
/**
 * 测试
 * @author Administrator
 *
 */
public class TestHuman {
	public static void main(String[] args) {
		/*
		 * 1.一种类型的引用，在指向不同对象时有不同的实现
		 * 		cut()----多态
		 */
			Human docter=new Doctor();
			docter.cut();
			Human cooker=new Cooker();
			cooker.cut();
			Human hairCut=new HairCut();
			hairCut.cut();
			
			
			
	}

}
