package ttkp;
/**
 * ������
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Background extends SuperClass{
	private int x1;
	private static BufferedImage images;
	
	// ��̬�����
	static {
		images = loadImage("a.jpg");
	}
	
	// ���캯��
	public Background() {
		super(wroldPanel1.WIDTH,wroldPanel1.HEIGHT, 0,0,-4);
		x1 = -wroldPanel1.WIDTH;
	}
	
	
	@Override
	public void step() {
		x += speed;
		x1 += speed;
		if(x <= -wroldPanel1.WIDTH) {
			x = wroldPanel1.WIDTH;
		}
		if(x1 <= -wroldPanel1.WIDTH) {
			x1 = wroldPanel1.WIDTH;
		}
	}

	@Override
	public BufferedImage getImage() {
		
		return images;
		
	}

	@Override
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
		g.drawImage(getImage(),x1,y,null);
	}

}
