package ttkp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Hero extends SuperClass{
	// ������״̬
	static final int RUNNING = 1;
	static final int JUMP_ONE = 2;
	static final int JUMP_TWO = 3;
	static final int JUMP_THREE = 4;
	static final int DOWN = 5;
	static final int FLYING = 6;
	// ����
	boolean flyingOnce; // ����ֻ����һ�ο���
	boolean changeHero; // �ı�Ӣ�ۿ���
	// λ�Ʊ��� 
	private double t; // s = v0*t + 0.5*g*t*t
	private int v0;
	private int g;
	private double s;
	private double speedy;
	// ͼƬ��
	BufferedImage[] images;
	BufferedImage[] images1;
	BufferedImage downImage;
	BufferedImage downImage1;
	// ��ʼ��״̬
	int myState = RUNNING;
	int groundY = 370; // �ذ�y����	�����ܵ�ʱ���y����
	int downHeight = 30; // ����֮���½��ĸ߶�
	double flyingSpeed = 1; //���������ٶ�
	
	public Hero() {
		super(123, 105, 170, 185, 0);
		t = 0.20;
		s = 0;
		v0 = 40;
		g = 6;
		speedy = 10;
		downImage = loadImage("loading_down.png");
		downImage1 = loadImage("loading1_down.png");
		
		images = new BufferedImage[12];
		images1 = new BufferedImage[12];
		
		// ���������е�ͼƬ��
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("loading_"+(i+1)+".png");
		}
		// ��������Ů��ͼƬ��
		for (int i = 0; i < images1.length; i++) {
			images1[i] = loadImage("loading1_"+(i+1)+".png");
		}
	}
	
	public static BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(Hero.class.getResource(fileName));
      return img;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	int index = 0;
	int imageIndex = 0;
	BufferedImage lastImage;
	
	
	@Override
	public BufferedImage getImage() {
		// ����Ӣ��״̬ͼƬ
		if(!changeHero) {
			switch(myState) {
			case JUMP_ONE: return images[4];
			case JUMP_TWO: return images[11];
			case JUMP_THREE: return images[4];
			case DOWN: return downImage;
			case FLYING: return images[5];
			case RUNNING:
				if(imageIndex++%4 == 0) {
					BufferedImage image = images[index++%12];
					lastImage = image;
					return image;
				}
				return lastImage;
			default: return null;
			}
		}else { // �ı��ɫ
			switch(myState) {
			case JUMP_ONE: return images1[4];
			case JUMP_TWO: return images1[11];
			case JUMP_THREE: return images1[4];
			case DOWN: return downImage1;
			case FLYING: return images1[5];
			case RUNNING:
				if(imageIndex++%4 == 0) {
					BufferedImage image = images1[index++%12];
					lastImage = image;
					return image;
				}
				return lastImage;
			default: return null;
			}
		}
	}

	@Override
	public void paintObject(Graphics g) {
		g.drawImage(getImage(),x,y,null);
	}
	// �ܲ�״̬�ж�����
	public void toRun() {
		if(y >= groundY && myState != DOWN) {
			myState = RUNNING;
			flyingOnce = true;
		}
	}
	// �����ܲ�״̬��ִ��
	public void run() {
		if(myState == RUNNING) {
			y = groundY;
		}
	}
	// ��������Ϊ��ִ�з���״̬
	public void fly() {
		if(myState != JUMP_THREE) {
			myState++;
			speedy = v0;
		}
	}
	// ��Ծ״̬
	public void jump() {
		if(myState != FLYING && myState != RUNNING && myState != DOWN) {
			double v0 = speedy;
			s = v0*t+0.5*g*t*t;
			y = y - (int)s;
			double v = v0 - g*t;
			speedy = v;
		}
	}
	// �¶�״̬
	public void down() {
		if(myState == DOWN) {
			y = groundY + downHeight;
		}
	}
	// ���ڷ���ʱִ��
	public void flying() {
		if(myState == FLYING) {
			y += flyingSpeed;
		}
	}
	// ��������(һ��/����/������)
	public boolean canFlying() {
		return myState == JUMP_ONE || myState == JUMP_TWO || myState == JUMP_THREE;
	}
	// ���������ٶȼ���
	public void hitStep() {
		x -= 4;
	}
	// �ܲ�����
	public void runQuick() {
		if(myState == RUNNING && x <= 961) {
			x += 3;
		}
	}
	// �ܲ�����
	public void runSlow() {
		if(myState == RUNNING && x >= -40) {
			x -= 5;
		}
	}

	// ��д��һ������
	@Override
	public void step() {
		jump();
		toRun();
		run();
		down();
		flying();
	}
}
