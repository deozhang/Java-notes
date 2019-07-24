package ttkp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 地板类
 * @author yingc
 *
 */
public class Ground extends SuperClass implements Award{
	// 私有属性
	private static BufferedImage image;
	// 静态代码块
	static {// 加载背景图
		image = loadImage("ground.png");
	}
	//构造函数
	public Ground(int x) {
		super(80, 200, x, 190, 4);
	}
	// 走一步方法
	@Override
	public void step() {
		// 在x方向设置一个速度
		this.x -= speed;
	}
	
	// 获取地板图
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
		}else {
			return null;
		}
	}
	
	// 绘制地板图
	@Override
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,width,height,null);
	}
	
	@Override
	public int getAwardType() {
		
		return 200;
		
	}

	

}
