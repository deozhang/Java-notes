package com.xms.basic.day08.tetris1;
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
		L l=new L();
		//����һ��Cell���͵Ķ���
		Cell c0=new Cell();
		c0.x=1;
		c0.y=1;
		//��Cell�������L���͵�l����ĳ�Ա����----Cell[]
		l.cell[0]=c0;
		
		//����һ��Cell���͵Ķ���
		Cell c1=new Cell();
		c1.x=1;
		c1.y=2;
		//��Cell�������L���͵�l����ĳ�Ա����----Cell[]
		l.cell[1]=c1;
		
		//����һ��Cell���͵Ķ���
		Cell c2=new Cell();
		c2.x=1;
		c2.y=3;
		//��Cell�������L���͵�l����ĳ�Ա����----Cell[]
		l.cell[2]=c2;
		
		//����һ��Cell���͵Ķ���
		Cell c3=new Cell();
		c3.x=2;
		c3.y=3;
		//��Cell�������L���͵�l����ĳ�Ա����----Cell[]
		l.cell[3]=c3;
		
		Main m=new Main();
		//2.��ӡLͼ�εķ���
		m.print(l);
		System.out.println("*****************************************************");
		l.lDown();
		//2.��ӡLͼ�εķ���
		m.print(l);
		
	}
	
	//��ӡLͼ�εķ���
	public void print(L l) {
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






























