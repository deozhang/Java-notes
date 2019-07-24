package ttkp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 金币类
 * @author yingc
 *
 */
public class Coin extends SuperClass implements Award{
	// 私有属性
	private static BufferedImage image;
	// 静态代码块
	static {// 加载图片
		image = loadImage("coin.png");
	}
	// 构造函数
	public Coin(int x,int y) {
		super(30, 30, x, y, 4);
	}
	
	// 重写移动
	@Override
	public void step() {
		x -= speed;
	}
	
	// 重写获取图片
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
		}else {
			return null;
		}
	}
	
	// 重写绘制图片
	@Override
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,30,30,null);
	}
	
	@Override
	public int getAwardType() {
		
		return 100;
		
	}



}
