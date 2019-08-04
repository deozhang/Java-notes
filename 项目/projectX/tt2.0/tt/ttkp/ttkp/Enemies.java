package ttkp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * ������
 *
 */
public class Enemies extends SuperClass implements Award{
	// ˽������
	private static BufferedImage image;
	// ��̬�����
	static {// ��ȡͼƬ
		image = loadImage("z.gif"); 
	}
	// ���캯��
	public Enemies(int x,int y) {
		super(66, 55, x, y, 4);
	}
	// ��һ������
	@Override
	public void step() {
		x -= speed;
	}
	// ��ȡͼƬ
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
		}else {
			return null;
		}
	}
	// ����ͼƬ
	@Override
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
	}
	
	@Override
	public int getAwardType() {
		
		return 20;
		
	}
}
