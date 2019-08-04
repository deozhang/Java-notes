package ttkp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 敌人类
 *
 */
public class Enemies extends SuperClass implements Award{
	// 私有属性
	private static BufferedImage image;
	// 静态代码块
	static {// 获取图片
		image = loadImage("z.gif"); 
	}
	// 构造函数
	public Enemies(int x,int y) {
		super(66, 55, x, y, 4);
	}
	// 走一步方法
	@Override
	public void step() {
		x -= speed;
	}
	// 获取图片
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
		}else {
			return null;
		}
	}
	// 绘制图片
	@Override
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
	}
	
	@Override
	public int getAwardType() {
		
		return 20;
		
	}
}
