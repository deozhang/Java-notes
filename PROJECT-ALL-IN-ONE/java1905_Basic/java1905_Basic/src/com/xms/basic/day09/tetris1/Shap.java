package com.xms.basic.day09.tetris1;
/**
 * ͼ����
 * @author Administrator
 *
 */
public class Shap {
	//��Ա����
		Cell[] cell;
		
		public Shap() {
			cell=new Cell[4];
		}
		
		//��Ա����
		//����
		public void sDown() {
			for(int i=0;i<cell.length;i++) {
				cell[i].down();
			}
		}
		//����
		public void sLeft() {
			for(int i=0;i<cell.length;i++) {
				cell[i].left();
			}
		}
		//����
		public void sRight() {
			for(int i=0;i<cell.length;i++) {
				cell[i].right();
			}
		}
				

}
