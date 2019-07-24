package ttkp;
/**
 * 基本对象超类
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class SuperClass {
	public static final int LIFE = 10;
	public static final int DEAD = 11;
	protected int state = LIFE;
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	protected int speed;
	
	// 构造函数
	public SuperClass(int width, int height, int x, int y, int speed) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	/** 走一步抽象方法 **/
	public abstract void step();
	
	// 加载图片方法
	public static BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(SuperClass.class.getResource(fileName));
			return img;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/** 获取图片抽象方法 **/
	public abstract BufferedImage getImage();
	
	// 判断是否生存方法
	public boolean isLife() {
		return state == LIFE;
	}
	
	// 判断是否死亡方法
	public boolean isDead() {
		return state == DEAD;
	}
	
	// 致死方法
	public void goDead() {
		state = DEAD;
	}
			
	// 判断物体相碰撞方法
	public boolean hit(SuperClass other) {
		int x1 = this.x-other.width+10;
		int x2 = this.x+this.width-60;
		int y1 = this.y-other.height;
		int y2 = this.y+this.height;
		
		int x = other.x;
		int y = other.y;
		
		return x >= x1 && x <= x2 && y >= y1 && y <= y2; 
	}
	
	/** 绘制物体抽象方法 **/
	public abstract void paintObject(Graphics g);
	
	// 判断是否出界方法
	public boolean outOfBounds() {
		return x < -width;
	}
}
