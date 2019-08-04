package com.xms.basic.day09.tetris1;
/**
 * 主类
 * 开发原则：
 * 		高内聚：一个类自身完成某件事的能力
 * 		低耦合：
 * 
 * @author Administrator
 *
 */
public class Main {
	public static void  main(String[] args) {
		/*
		 * 打印L图形
		 * 1.创建L对象
		 * 2.调用打印L图形方法
		 * 
		 */
		//1.创建L类型的对象
		L l=new L(1,1);
		Main m=new Main();
		//2.打印L图形的方法
		m.print(l);
		System.out.println("*****************************************************");
		l.sDown();
		//2.打印L图形的方法
		m.print(l);
		System.out.println("****T*******************************");
		Shap t=new T(4,4);
		m.print(t);
		
	}
	
//	//打印L图形的方法
//	public void print(L l) {
//		for(int i=0;i<10;i++) {//行
//			//行的内容
//			for(int j=0;j<10;j++) {//列
//				//列的内容
//				if(l.cell[0].x==j&&l.cell[0].y==i||
//						l.cell[1].x==j&&l.cell[1].y==i||
//						l.cell[2].x==j&&l.cell[2].y==i||
//						l.cell[3].x==j&&l.cell[3].y==i) {
//					System.out.print("* ");
//				}else {
//					System.out.print("- ");
//				}
//			}
//			//换行
//			System.out.println();
//		}
//	}
	//打印图形的方法
	public void print(Shap l) {
		for(int i=0;i<10;i++) {//行
			//行的内容
			for(int j=0;j<10;j++) {//列
				//列的内容
				if(l.cell[0].x==j&&l.cell[0].y==i||
						l.cell[1].x==j&&l.cell[1].y==i||
						l.cell[2].x==j&&l.cell[2].y==i||
						l.cell[3].x==j&&l.cell[3].y==i) {
					System.out.print("* ");
				}else {
					System.out.print("- ");
				}
			}
			//换行
			System.out.println();
		}
	}

}






























