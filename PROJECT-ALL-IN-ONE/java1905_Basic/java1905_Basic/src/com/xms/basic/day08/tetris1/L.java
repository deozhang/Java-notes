package com.xms.basic.day08.tetris1;
/**
 * L��
 * @author Administrator
 *
 */
public class L {
	//��Ա����
	Cell[] cell=new Cell[4];
	
	//��Ա����
	//����
	public void lDown() {
		for(int i=0;i<cell.length;i++) {
			cell[i].down();
		}
	}
	//����
	public void lLeft() {
		for(int i=0;i<cell.length;i++) {
			cell[i].left();
		}
	}
	//����
	public void lRight() {
		for(int i=0;i<cell.length;i++) {
			cell[i].right();
		}
	}
			

}
