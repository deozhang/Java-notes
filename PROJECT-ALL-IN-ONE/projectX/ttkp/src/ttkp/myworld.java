package ttkp;
/**
 * 界面运行类
 */
import javax.swing.JFrame;

public class myworld {
	 public static void main(String[] args) {
		   JFrame frame = new JFrame();
		   wroldPanel1 panel = new wroldPanel1();
		   frame.add(panel);
		  
			//线程关联
			Thread t = new Thread(panel);
			t.start();

			frame.addKeyListener(panel);
			frame.setSize(925,700);
			//3.设置窗口居中显示
			frame.setLocationRelativeTo(null);
			//4.设置窗口关闭模式
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setFocusable(true);
			//5.设置可见
			frame.setVisible(true);
			// panel.runing();
	    }
}
