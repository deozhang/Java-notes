package com.xms.basic.day09.tetris1;
/**
 * L��
 * @author Administrator
 *
 */
public class L extends Shap {
	
	public L() {
		
	}
	
	/*
	 * ���ⲿ�����Lͼ�ε�����
	 */
	public L(int x,int y) {
		cell[0]=new Cell(x,y);
		cell[1]=new Cell(x,y+1);
		cell[2]=new Cell(x,y+2);
		cell[3]=new Cell(x+1,y+2);
		
	}
	

}
