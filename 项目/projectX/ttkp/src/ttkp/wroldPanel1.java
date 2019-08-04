package ttkp;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;


public class wroldPanel1  extends JPanel implements Runnable,KeyListener {
	public static final int WIDTH = 1100;
	public static final int HEIGHT = 620;
	
	public static final int START = 0; // 启动状态
	public static final int RUN = 1; // 运行状态
	public static final int PAUSE = 2; // 暂停状态
	public static final int GAME_OVER = 3; //游戏结束状态
	public static final int COMPOSING_WIDTH = 2400;  //排版宽度
	
	/**私有属性**/
	private static int state = START;  // 游戏状态'
	// 游戏开始图片
	private static BufferedImage start;
	// 游戏暂停图片
	private static BufferedImage pause;
	// 游戏结束图片
	private static BufferedImage gameover;
	
	/**静态代码块**/
	static { // 初始化静态图片
		start = SuperClass.loadImage("start1.jpg");
		pause = SuperClass.loadImage("pause.png");
		gameover = SuperClass.loadImage("gameover.png");
	}
	// 创建英雄
	Hero hero = new Hero();
	// 创建背景
	Background back = new Background();
	// 奖励(金币)对象集
	SuperClass[] award = {};
	// 障碍物类对象集
	Ground[] grounds = {};
	// 敌人对象集
	Enemies[] enemies = {};
	
	// 生成金币银币奖励数组
	public SuperClass[] nextOneBigAward() {
		// 生成随机数
		Random rand = new Random();
		int type = rand.nextInt(25);
		
		int goldWidths = 40; // 金币之间的距离
		/**绘制心形金币图*/
		if(type < 7) {
			GoldAward[] golds = new GoldAward[26];// 生成金币奖励数组
			for (int i = 0; i < 13; i++) {
				if(i <= 6) {
					golds[i] = new GoldAward(WIDTH+goldWidths*i,200+goldWidths*i);
				}else {
					golds[i] = new GoldAward(WIDTH+goldWidths*i,200+goldWidths*(13-i-1));
				}
			}
			golds[13] = new GoldAward(WIDTH+goldWidths*0, 200-40);
			golds[14] = new GoldAward(WIDTH+goldWidths*1, 200-70);
			golds[15] = new GoldAward(WIDTH+goldWidths*2, 200-80);
			golds[16] = new GoldAward(wroldPanel1.WIDTH+goldWidths*3, 200-60);
			golds[17] = new GoldAward(wroldPanel1.WIDTH+goldWidths*4, 200-50);
			golds[18] = new GoldAward(wroldPanel1.WIDTH+goldWidths*5, 200-40);
			golds[19] = new GoldAward(wroldPanel1.WIDTH+goldWidths*6, 200-20);
			golds[20] = new GoldAward(wroldPanel1.WIDTH+goldWidths*7, 200-40);
			golds[21] = new GoldAward(wroldPanel1.WIDTH+goldWidths*8, 200-50);
			golds[22] = new GoldAward(wroldPanel1.WIDTH+goldWidths*9, 200-60);
			golds[23] = new GoldAward(wroldPanel1.WIDTH+goldWidths*10, 200-80);
			golds[24] = new GoldAward(wroldPanel1.WIDTH+goldWidths*11, 200-70);
			golds[25] = new GoldAward(wroldPanel1.WIDTH+goldWidths*12, 200-40);
			return golds;
			/***/
		}else if(type < 15) {/**绘制田字形金币交错的图* * * * * *
 		                               *    *   *  **/
			GoldAward[] g = new GoldAward[33];
			int index = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if(i == 0 || i == 3 || i == 6 || j == 0 || j == 3 || j == 6) {
						g[index++] = new GoldAward(wroldPanel1.WIDTH+goldWidths*i,100+goldWidths*j);
					}
				}
			}
			return g;/****/
		}else {/**15~25时, 绘制满矩形银币数组....***/
			Coin[] coins = new Coin[49];
			int index = 0;
			for (int i = 1; i < 8; i++) {
				for (int j = 1; j < 8; j++) {
					coins[index++]= new Coin(wroldPanel1.WIDTH+goldWidths*i,100+goldWidths*j);
				}
			}
			return coins;/****/
		}
	}
	
	// 生成金币银币奖励数组
	public SuperClass[] nextOneSmallAward() {
		Random rand = new Random();
		int type = rand.nextInt(25);
		int goldWidths = 40;
		if(type < 15) {//尖型金币图
			GoldAward[] golds = new GoldAward[7];
			for (int i = 0; i < golds.length; i++) {
				if(i < 3) {
					golds[i] = new GoldAward(wroldPanel1.WIDTH+goldWidths*i,350-goldWidths*i);
				}else{
					golds[i] = new GoldAward(wroldPanel1.WIDTH+goldWidths*i,350-goldWidths*(7-i-1));
				}
			}
			return golds;/****/
		}else {/*双层银币拱形**/
			Coin[] coins = new Coin[14];
			for (int i = 0; i < 7; i++) {
				if(i < 3) {
					coins[i] = new Coin(wroldPanel1.WIDTH+goldWidths*i,350-goldWidths*i);
				}else {
					coins[i] = new Coin(wroldPanel1.WIDTH+goldWidths*i,350-goldWidths*(7-i-1));
				}
			}
			for (int i = 7; i < 14; i++) {
				if(i < 10) {
					coins[i] = new Coin(wroldPanel1.WIDTH+goldWidths*(i-7),350-goldWidths*(i-7+1));
				}else {
					coins[i] = new Coin(wroldPanel1.WIDTH+goldWidths*(i-7),350-goldWidths*(15-i-1));
				}
			}
			return coins;
		}/***/
	}
	public Ground[] nextOneGround() {
		Ground[] grounds = new Ground[2];
		grounds[0] = new Ground(wroldPanel1.WIDTH+COMPOSING_WIDTH/6);
		grounds[1] = new Ground(wroldPanel1.WIDTH+COMPOSING_WIDTH*5/6);
		return grounds;
	}

	// 生成敌人
	public Enemies[] nextOneEnemies() {
		Enemies[] enemies =  new Enemies[3];
		for (int i = 0; i < 3; i++) {
			enemies[i] = new Enemies(wroldPanel1.WIDTH+COMPOSING_WIDTH/3*i+100,420);
		}
		return enemies;
	}

	// 生成敌人旁边的敌人
	public Enemies[] nextAnotherEnemies() {
		Enemies[] enemies = new Enemies[3];
		for (int i = 0; i < 3; i++) {
			enemies[i] = new Enemies(WIDTH+COMPOSING_WIDTH/3*i+100,420+300);
		}
		return enemies;
	}
	

	// 频率变量
	int enterIndex = 0;
	int enterIndex1 = enterIndex - COMPOSING_WIDTH/12;//-200
	int enterIndex2 = enterIndex - COMPOSING_WIDTH/6;//-400
	int index = 0;
	
	// 入场
	public void enterAction() {
		if(enterIndex++%600 == 0) {
			SuperClass[] obj = nextOneBigAward();
			// 数组扩容
			award = Arrays.copyOf(award, award.length+obj.length);
			System.arraycopy(obj, 0, award, award.length-obj.length, obj.length);
		}
		if(enterIndex1++%600 == 0) {
			SuperClass[] obj = nextOneSmallAward();
			award = Arrays.copyOf(award, award.length+obj.length);
			System.arraycopy(obj, 0, award, award.length-obj.length, obj.length);
			
			Enemies[] enemy = nextOneEnemies();
			enemies = Arrays.copyOf(enemies,enemies.length+enemy.length);
			System.arraycopy(enemy, 0, enemies, enemies.length-enemy.length , enemy.length);
			
			if(enterIndex1 > 0) {
				Enemies[] enemy1 = nextAnotherEnemies();
				enemies = Arrays.copyOf(enemies, enemies.length+enemy1.length);
				System.arraycopy(enemy1, 0, enemies, enemies.length-enemy1.length, enemy1.length);
			}
		}
		if(enterIndex2++%600 == 0) {/**生成地板类(障碍物)*/
			Ground[] obj = nextOneGround();
			// 越过障碍物分数
			for (int i = 0; i < obj.length; i++) {
				index += obj[i].getAwardType();
			}
			grounds = Arrays.copyOf(grounds, grounds.length+obj.length);
			System.arraycopy(obj,0,grounds,grounds.length-obj.length,obj.length);
		}
	}
	
	
	int score = 0;
	// 检测碰撞(碰撞得分, 碰撞减速)
	public void hitAction() {
		// 英雄碰撞金币得分
		for (int i = 0; i < award.length; i++) {
			SuperClass a = award[i];// 临时变量a
			if(a.hit(hero) && a.isLife()) {
				a.goDead();
				if(a instanceof Award) {
					Award e = (Award)a;
					score += e.getAwardType();// 生成金币银币分数
				}
			}
		}
		// 英雄碰撞障碍物
		for (int i = 0; i < grounds.length; i++) {
			Ground g = grounds[i];
			if(g.hit(hero)) {
				if(hero.x+hero.width < g.x+15 || hero.y > hero.groundY - 10) {
					hero.hitStep();// 速度减慢
				}
			if(hero.y+hero.height < g.y+20) {
				hero.fly();
					hero.myState = Hero.JUMP_TWO; 				}
			}
		}
	}
	
	// 各种对象越界后删除
	public void OutOfBoundAction() {
		// 金币对象越界消失
		int index = 0;
		SuperClass[] awardLives = new SuperClass[award.length];
		for (int i = 0; i < award.length; i++) {
			SuperClass s = award[i];// 临时变量s存储金币对象
			if(!s.outOfBounds() && s.isLife()) {
				awardLives[index++] = s;
			}
		}
		award = Arrays.copyOf(awardLives, index);
		
		// 障碍物对象越界消失
		index = 0;
		Ground[] groundLives = new Ground[grounds.length]; 
		for (int i = 0; i < grounds.length; i++) {
			Ground g = grounds[i];
			if(!g.outOfBounds() && g.isLife()) {
				groundLives[index++] = g;
			}
		}
		grounds = Arrays.copyOf(groundLives, index);
		
		// 敌人消失
		index = 0;
		Enemies[] enemiesLives = new Enemies[enemies.length];
		for (int i = 0; i < enemies.length; i++) {
			Enemies e = enemies[i];
			if(!e.outOfBounds() && e.isLife()) {
				enemiesLives[index++] = e;
			}
		}
		enemies = Arrays.copyOf(enemiesLives, index);
	}

	int distance;
	// 获取距离
	public void getDistance() {
		distance = (int)enterIndex/10;
	}

	
	// 障碍物, 金币, 敌人移动
	public void stepAction() {
		for (int i = 0; i < award.length; i++) {
			award[i].step();

		}
		for (int i = 0; i < grounds.length; i++) {
			grounds[i].step();
		}
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].step();
		}
		back.step();
		hero.step();
	}
         public void musicAction() {
        	 File file1 = new File("e:\\Java-Full-Stack\\PROJECT-ALL-IN-ONE\\projectX\\tt2.0\\tt\\ttkp\\ttkp\\a.wav");
             AudioClip sound1;
        		
	     try {
			sound1 = Applet.newAudioClip(file1.toURL());
			sound1.play();
	      } catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
	     	e1.printStackTrace();
	   }

}
	
	
	
	/** 绘制对象 **/
	public void paint(Graphics g) {
		if(state == RUN || state == PAUSE || state == GAME_OVER) {
			back.paintObject(g);
			// 绘制奖励对象
			for (int i = 0; i < award.length; i++) {
				award[i].paintObject(g);
			}
			// 绘制敌人
			for (int i = 0; i < enemies.length; i++) {
				enemies[i].paintObject(g);
			}
			// 绘制英雄
			hero.paintObject(g);
			// 绘制 障碍物/地板 
			for (int i = 0; i < grounds.length; i++) {
				grounds[i].paintObject(g);
			}
			g.setFont(new Font("",Font.BOLD,20));
			g.drawString("距离:  "+distance+"  米", 40, 40);
			g.drawString("得分:   "+(score+index), 40, 60);
		}
		/**绘制开始时图片*/
		if(state == START) {
			g.drawImage(start, 0, 0,wroldPanel1.WIDTH,wroldPanel1.HEIGHT,null);
			g.setFont(new Font("微软雅黑",Font.BOLD,20));
			g.setColor(Color.YELLOW);
			g.drawString("操作指南:", 300, 460);
			g.setColor(Color.GRAY);
			
			g.drawString("上键：                         下键:", 300, 485);
			g.drawString("左键:                           右键:", 300, 505);
			g.drawString("数字1键：                    数字2键:", 300, 525);
			g.drawString("空格：                                ESC键:", 300, 545);
			
			g.setColor(Color.BLACK);
			g.drawString("跳跃                                下蹲", 360, 485);
			g.drawString("慢跑                                加速跑/滑翔", 360, 505);
			g.drawString("  切换为男孩                      切换为女孩", 375, 525);
			g.drawString("开始游戏/暂停游戏                      结束游戏", 360, 545);
		}
		/**绘制暂停时图片**/
		if(state == PAUSE) {
			g.drawImage(pause, 0, 0,wroldPanel1.WIDTH, wroldPanel1.HEIGHT, null);
		}
		/**绘制结束时图片**/
		if(state == GAME_OVER) {
			g.drawImage(gameover,0,0,wroldPanel1.WIDTH,wroldPanel1.HEIGHT,null);
		}
	}
	
	
	// 检测英雄越界并死亡的方法
	public void checkGameoverAction() {
		if(hero.outOfBounds()) {
			state = GAME_OVER;
		}
		for (int i = 0; i < enemies.length; i++) {
			if(enemies[i].hit(hero)) {
				state = GAME_OVER;
			}
		}
	}
     
	//-----------
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 当点击上键时
//		if(e.getKeyCode() == KeyEvent.VK_UP) {
		if(e.getKeyCode() == 38) {
			// 在正常跑时才可以跳
			if(state == RUN) {
				if(hero.myState != Hero.DOWN && hero.myState < Hero.JUMP_THREE) {
					hero.fly();
					// 最高只能三级跳
					if(hero.myState == Hero.JUMP_THREE && hero.y >= hero.groundY) {
						hero.myState = Hero.RUNNING;
					}
				}
			}
		}
		// 点击 1 键时不可变身
		if(e.getKeyCode() == KeyEvent.VK_1) {
//		if(e.getKeyCode() == 97) {
			hero.changeHero = false;
		}
		// 点击 2 键时可变身
		if(e.getKeyCode() == KeyEvent.VK_2) {
//		if(e.getKeyCode() == 98) {
			hero.changeHero = true;
		}
		// 点击 ESC 键时(27)结束游戏
//		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		if(e.getKeyCode() == 27) {
			if(state == RUN) {
				state = GAME_OVER;
			}
		}
		// 点击空格时,暂停,重新开始
//		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
		if(e.getKeyCode() == 32) {
			if(state == START) {
				state = RUN;
			}else if(state == RUN) {
				state = PAUSE;
			}else if(state == PAUSE) {
				state = RUN;
			}else if(state == GAME_OVER) {
				hero = new Hero();
				back = new Background();
				award = new SuperClass[0];
				grounds = new Ground[0];
				enemies = new Enemies[0];
				score = 0;
				index = 0;
				enterIndex = 0;
				enterIndex1 = enterIndex - COMPOSING_WIDTH/12;
				enterIndex2 = enterIndex - COMPOSING_WIDTH/6;
				state = START;
			}
		}
		// 释放下键时
//		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
		if(e.getKeyCode() == 40) {
			hero.myState = Hero.RUNNING;
		}
		// 释放右键时
//		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		if(e.getKeyCode() == 39) {
			hero.flyingOnce = false;
			if(hero.y < hero.groundY) {
				hero.myState = Hero.JUMP_THREE;
			}
		}
}
 
	public void keyPressed(KeyEvent e) {
		// 按住下键时
//		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
		if(e.getKeyCode() == 40) {
			if(hero.myState == Hero.RUNNING) {
				hero.myState = Hero.DOWN;
			}
		}
		// 按住右键时
//		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		if(e.getKeyCode() == 39) {
			if(hero.canFlying() && hero.flyingOnce) {
				hero.myState = Hero.FLYING;
			}
			hero.runQuick();
		}
		// 按住左键
//		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
		if(e.getKeyCode() == 37) {
			hero.runSlow();
		}
	}

	@Override
	public void run() {
		
		while(true) {
		if(state==RUN){
			enterAction();
			stepAction();
			hitAction();
			OutOfBoundAction();
			getDistance();
			checkGameoverAction();
		        musicAction();
		}
		
		try {
			Thread.sleep(10);// runable
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}
		}
}

