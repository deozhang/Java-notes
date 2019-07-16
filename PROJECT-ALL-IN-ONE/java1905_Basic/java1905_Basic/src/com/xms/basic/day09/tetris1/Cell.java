package com.xms.basic.day09.tetris1;
/**
 * 方块类
 * @author Administrator
 *
 */
public class Cell {
	//成员变量
	//方块的坐标
	int x;//横坐标
	int y;//纵坐标
	
	//构造方法
	public Cell() {
		
	}
	
	public Cell(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	//成员方法
	//下落的方法
	public void down() {
		y++;
	}
	//左移的方法
	public void left() {
		x--;
	}
	//右移的方法
	public void right() {
		x++;
	}

	
}




















