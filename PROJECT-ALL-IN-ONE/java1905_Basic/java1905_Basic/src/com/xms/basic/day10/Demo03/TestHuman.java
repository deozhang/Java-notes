package com.xms.basic.day10.Demo03;
/**
 * ����
 * @author Administrator
 *
 */
public class TestHuman {
	public static void main(String[] args) {
		/*
		 * 1.һ�����͵����ã���ָ��ͬ����ʱ�в�ͬ��ʵ��
		 * 		cut()----��̬
		 */
			Human docter=new Doctor();
			docter.cut();
			Human cooker=new Cooker();
			cooker.cut();
			Human hairCut=new HairCut();
			hairCut.cut();
			
			
			
	}

}
