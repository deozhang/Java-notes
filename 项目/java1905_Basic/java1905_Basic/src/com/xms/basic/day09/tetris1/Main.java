package com.xms.basic.day09.tetris1;
/**
 * ����
 * ����ԭ��
 * 		���ھۣ�һ�����������ĳ���µ�����
 * 		����ϣ�
 * 
 * @author Administrator
 *
 */
public class Main {
	public static void  main(String[] args) {
		/*
		 * ��ӡLͼ��
		 * 1.����L����
		 * 2.���ô�ӡLͼ�η���
		 * 
		 */
		//1.����L���͵Ķ���
		L l=new L(1,1);
		Main m=new Main();
		//2.��ӡLͼ�εķ���
		m.print(l);
		System.out.println("*****************************************************");
		l.sDown();
		//2.��ӡLͼ�εķ���
		m.print(l);
		System.out.println("****T*******************************");
		Shap t=new T(4,4);
		m.print(t);
		
	}
	
//	//��ӡLͼ�εķ���
//	public void print(L l) {
//		for(int i=0;i<10;i++) {//��
//			//�е�����
//			for(int j=0;j<10;j++) {//��
//				//�е�����
//				if(l.cell[0].x==j&&l.cell[0].y==i||
//						l.cell[1].x==j&&l.cell[1].y==i||
//						l.cell[2].x==j&&l.cell[2].y==i||
//						l.cell[3].x==j&&l.cell[3].y==i) {
//					System.out.print("* ");
//				}else {
//					System.out.print("- ");
//				}
//			}
//			//����
//			System.out.println();
//		}
//	}
	//��ӡͼ�εķ���
	public void print(Shap l) {
		for(int i=0;i<10;i++) {//��
			//�е�����
			for(int j=0;j<10;j++) {//��
				//�е�����
				if(l.cell[0].x==j&&l.cell[0].y==i||
						l.cell[1].x==j&&l.cell[1].y==i||
						l.cell[2].x==j&&l.cell[2].y==i||
						l.cell[3].x==j&&l.cell[3].y==i) {
					System.out.print("* ");
				}else {
					System.out.print("- ");
				}
			}
			//����
			System.out.println();
		}
	}

}






























