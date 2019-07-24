package ttkp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * �ذ���
 * @author yingc
 *
 */
public class Ground extends SuperClass implements Award{
	// ˽������
	private static BufferedImage image;
	// ��̬�����
	static {// ���ر���ͼ
		image = loadImage("ground.png");
	}
	//���캯��
	public Ground(int x) {
		super(80, 200, x, 190, 4);
	}
	// ��һ������
	@Override
	public void step() {
		// ��x��������һ���ٶ�
		this.x -= speed;
	}
	
	// ��ȡ�ذ�ͼ
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
		}else {
			return null;
		}
	}
	
	// ���Ƶذ�ͼ
	@Override
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,width,height,null);
	}
	
	@Override
	public int getAwardType() {
		
		return 200;
		
	}

	

}
