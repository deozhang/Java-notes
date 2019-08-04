package com.xms.basic.day08.tetris1;
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
		L l=new L();
		//创建一个Cell类型的对象
		Cell c0=new Cell();
		c0.x=1;
		c0.y=1;
		//将Cell对象放入L类型的l对象的成员变量----Cell[]
		l.cell[0]=c0;
		
		//创建一个Cell类型的对象
		Cell c1=new Cell();
		c1.x=1;
		c1.y=2;
		//将Cell对象放入L类型的l对象的成员变量----Cell[]
		l.cell[1]=c1;
		
		//创建一个Cell类型的对象
		Cell c2=new Cell();
		c2.x=1;
		c2.y=3;
		//将Cell对象放入L类型的l对象的成员变量----Cell[]
		l.cell[2]=c2;
		
		//创建一个Cell类型的对象
		Cell c3=new Cell();
		c3.x=2;
		c3.y=3;
		//将Cell对象放入L类型的l对象的成员变量----Cell[]
		l.cell[3]=c3;
		
		Main m=new Main();
		//2.打印L图形的方法
		m.print(l);
		System.out.println("*****************************************************");
		l.lDown();
		//2.打印L图形的方法
		m.print(l);
		
	}
	
	//打印L图形的方法
	public void print(L l) {
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






























