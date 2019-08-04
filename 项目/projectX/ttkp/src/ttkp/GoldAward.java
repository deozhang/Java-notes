package ttkp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * �����
 * @author yingc
 *
 */
public class GoldAward extends SuperClass implements Award{
	// ˽������
	private static BufferedImage image;
	// ��̬�����
	static { // ����ͼƬ
		image = loadImage("jin.png");
	}
	// ���캯��
	public GoldAward(int x,int y) {
		super(30, 30, x, y, 4);
	}
	// ��д�ƶ�
	@Override
	public void step() {
		x -= speed;
	}
	// ��д��ȡͼƬ
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
		}else {
			return null;
		}
	}
	// ��д��ͼ����
	@Override
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,30,30,null);
	}
	@Override
	public int getAwardType() {
		
		return 150;
		
	}
}
