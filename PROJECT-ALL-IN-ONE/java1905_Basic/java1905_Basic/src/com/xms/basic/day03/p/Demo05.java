package com.xms.basic.day03.p;

import java.util.Scanner;

/**
 * 5.��������ָ���·ݣ���ӡ���·������ļ���
//3��4,5����  6,7,8�ļ�  9,10,11�＾ 12��1,2����
���ֱ�ʹ��||��&&�������
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�������·ݣ���1~12��");
		int  month=sc.nextInt();
		if(month>=1&&month<=12) {//����������ȷ
			if(month>=3&&month<=5) {
				System.out.println("��");
			}else if(month>=6&&month<=8) {
				System.out.println("��");
			}else if(month>=9&&month<=11) {
				System.out.println("��");
			}else if(month==12||month==1||month==2) {
				System.out.println("��");
			}
		}else {//������������
			System.out.println("�������벻��ȷ");
		}
	}

}

































