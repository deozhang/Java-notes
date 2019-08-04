package ttkp;
/**
 * ����������
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
	
	// ���캯��
	public SuperClass(int width, int height, int x, int y, int speed) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	/** ��һ�����󷽷� **/
	public abstract void step();
	
	// ����ͼƬ����
	public static BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(SuperClass.class.getResource(fileName));
			return img;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/** ��ȡͼƬ���󷽷� **/
	public abstract BufferedImage getImage();
	
	// �ж��Ƿ����淽��
	public boolean isLife() {
		return state == LIFE;
	}
	
	// �ж��Ƿ���������
	public boolean isDead() {
		return state == DEAD;
	}
	
	// ��������
	public void goDead() {
		state = DEAD;
	}
			
	// �ж���������ײ����
	public boolean hit(SuperClass other) {
		int x1 = this.x-other.width+10;
		int x2 = this.x+this.width-60;
		int y1 = this.y-other.height;
		int y2 = this.y+this.height;
		
		int x = other.x;
		int y = other.y;
		
		return x >= x1 && x <= x2 && y >= y1 && y <= y2; 
	}
	
	/** ����������󷽷� **/
	public abstract void paintObject(Graphics g);
	
	// �ж��Ƿ���緽��
	public boolean outOfBounds() {
		return x < -width;
	}
}
