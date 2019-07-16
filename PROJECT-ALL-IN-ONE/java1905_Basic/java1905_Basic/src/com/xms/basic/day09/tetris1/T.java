package com.xms.basic.day09.tetris1;

public class T extends Shap{
	public T() {
		
	}
	public T(int x,int y) {
		cell[0]=new Cell(x,y);
		cell[1]=new Cell(x+1,y);
		cell[2]=new Cell(x+2,y);
		cell[3]=new Cell(x+1,y+1);
	}
	

}
