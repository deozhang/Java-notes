package com.xms.basic.day03.p;

import java.util.Scanner;

/**
 * 4.�����û��������ֵ��ͬ����ӡ��Ӧ������//if��switch-case
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���������֣�1~7����");
		int num=sc.nextInt();
		if(num>=1&&num<=7) {//����������ȷ�����
			if(num==1) {
				System.out.println("��һ");
			}else if(num==2) {
				System.out.println("�ܶ�");
			}else if(num==3) {
				System.out.println("����");
			}else if(num==4) {
				System.out.println("����");
			}else if(num==5) {
				System.out.println("����");
			}else if(num==6) {
				System.out.println("����");
			}else if(num==7) {
				System.out.println("����");
			}
		}else {//�������벻��ȷ�����
			System.out.println("������������");
		}
		
		System.out.println("-----switch-case-----------------------------------------");
		switch (num) {
		case 1:
			System.out.println("��һ");
			break;
		case 2:
			System.out.println("�ܶ�");
			break;
		case 3:
			System.out.println("����");
			break;
		case 4:
			System.out.println("����");
			break;
		case 5:
			System.out.println("����");
			break;
		case 6:
			System.out.println("����");
			break;
		case 7:
			System.out.println("����");
			break;
		default:
			System.out.println("������������");
			break;
		}
		
	}

}









































