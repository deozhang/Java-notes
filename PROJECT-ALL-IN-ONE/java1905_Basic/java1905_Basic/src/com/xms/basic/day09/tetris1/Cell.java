package com.xms.basic.day09.tetris1;
/**
 * ������
 * @author Administrator
 *
 */
public class Cell {
	//��Ա����
	//���������
	int x;//������
	int y;//������
	
	//���췽��
	public Cell() {
		
	}
	
	public Cell(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	//��Ա����
	//����ķ���
	public void down() {
		y++;
	}
	//���Ƶķ���
	public void left() {
		x--;
	}
	//���Ƶķ���
	public void right() {
		x++;
	}

	
}




















