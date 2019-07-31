package ttkp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Hero extends SuperClass{
	// 各动作状态
	static final int RUNNING = 1;
	static final int JUMP_ONE = 2;
	static final int JUMP_TWO = 3;
	static final int JUMP_THREE = 4;
	static final int DOWN = 5;
	static final int FLYING = 6;
	// 开关
	boolean flyingOnce; // 控制只滑翔一次开关
	boolean changeHero; // 改变英雄开关
	// 位移变量 
	private double t; // s = v0*t + 0.5*g*t*t
	private int v0;
	private int g;
	private double s;
	private double speedy;
	// 图片集
	BufferedImage[] images;
	BufferedImage[] images1;
	BufferedImage downImage;
	BufferedImage downImage1;
	// 初始化状态
	int myState = RUNNING;
	int groundY = 370; // 地板y坐标	计算跑的时候的y坐标
	int downHeight = 30; // 蹲下之后下降的高度
	double flyingSpeed = 1; //滑翔掉落的速度
	
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
		
		// 加载人物男的图片集
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("loading_"+(i+1)+".png");
		}
		// 加载人物女的图片集
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
		// 更改英雄状态图片
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
		}else { // 改变角色
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
	// 跑步状态判定条件
	public void toRun() {
		if(y >= groundY && myState != DOWN) {
			myState = RUNNING;
			flyingOnce = true;
		}
	}
	// 进入跑步状态需执行
	public void run() {
		if(myState == RUNNING) {
			y = groundY;
		}
	}
	// 以三阶跳为界执行飞行状态
	public void fly() {
		if(myState != JUMP_THREE) {
			myState++;
			speedy = v0;
		}
	}
	// 跳跃状态
	public void jump() {
		if(myState != FLYING && myState != RUNNING && myState != DOWN) {
			double v0 = speedy;
			s = v0*t+0.5*g*t*t;
			y = y - (int)s;
			double v = v0 - g*t;
			speedy = v;
		}
	}
	// 下蹲状态
	public void down() {
		if(myState == DOWN) {
			y = groundY + downHeight;
		}
	}
	// 正在飞行时执行
	public void flying() {
		if(myState == FLYING) {
			y += flyingSpeed;
		}
	}
	// 飞行条件(一阶/二阶/三阶跳)
	public boolean canFlying() {
		return myState == JUMP_ONE || myState == JUMP_TWO || myState == JUMP_THREE;
	}
	// 碰到物体速度减慢
	public void hitStep() {
		x -= 4;
	}
	// 跑步加速
	public void runQuick() {
		if(myState == RUNNING && x <= 961) {
			x += 3;
		}
	}
	// 跑步减速
	public void runSlow() {
		if(myState == RUNNING && x >= -40) {
			x -= 5;
		}
	}

	// 重写走一步方法
	@Override
	public void step() {
		jump();
		toRun();
		run();
		down();
		flying();
	}
}
