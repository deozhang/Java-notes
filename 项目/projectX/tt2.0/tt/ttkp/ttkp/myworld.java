package ttkp;
/**
 * ����������
 */
import javax.swing.JFrame;

public class myworld {
	 public static void main(String[] args) {
		   JFrame frame = new JFrame();
		   wroldPanel1 panel = new wroldPanel1();
		   frame.add(panel);
		  
			//�̹߳���
			Thread t = new Thread(panel);
			t.start();

			frame.addKeyListener(panel);
			frame.setSize(925,700);
			//3.���ô��ھ�����ʾ
			frame.setLocationRelativeTo(null);
			//4.���ô��ڹر�ģʽ
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setFocusable(true);
			//5.���ÿɼ�
			frame.setVisible(true);
			// panel.runing();
	    }
}
