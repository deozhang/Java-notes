package com.xms.basic.day10.Demo04;
/**
 * 
 * @author Administrator
 *
 */
public class TestMy {
	//�����ڲ���
	InterFace my1=new InterFace() {
		public void add() {
			System.out.println("�ӷ�");
		}
	};
	public static void main(String[] args) {
		InterFace my=new My();
		my.add();
		
		//�ֲ������ڲ���--��Ҫ
		InterFace my2=new InterFace() {
			public void add() {
				System.out.println("�ӷ�");
			}
		};
		my2.add();
	}

}
