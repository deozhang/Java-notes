package com.xms.basic.day09.tetris1;
/**
 * 图形类
 * @author Administrator
 *
 */
public class Shap {
	//成员变量
		Cell[] cell;
		
		public Shap() {
			cell=new Cell[4];
		}
		
		//成员方法
		//下落
		public void sDown() {
			for(int i=0;i<cell.length;i++) {
				cell[i].down();
			}
		}
		//左移
		public void sLeft() {
			for(int i=0;i<cell.length;i++) {
				cell[i].left();
			}
		}
		//右移
		public void sRight() {
			for(int i=0;i<cell.length;i++) {
				cell[i].right();
			}
		}
				

}
