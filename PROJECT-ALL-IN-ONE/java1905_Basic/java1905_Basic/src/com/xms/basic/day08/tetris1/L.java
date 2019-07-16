package com.xms.basic.day08.tetris1;
/**
 * L类
 * @author Administrator
 *
 */
public class L {
	//成员变量
	Cell[] cell=new Cell[4];
	
	//成员方法
	//下落
	public void lDown() {
		for(int i=0;i<cell.length;i++) {
			cell[i].down();
		}
	}
	//左移
	public void lLeft() {
		for(int i=0;i<cell.length;i++) {
			cell[i].left();
		}
	}
	//右移
	public void lRight() {
		for(int i=0;i<cell.length;i++) {
			cell[i].right();
		}
	}
			

}
