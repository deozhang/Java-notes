package com.xms.basic.day04;

import java.util.Scanner;

/**
 * ��������
 * 
 * ���룺
 * ����:double
 * ������double
 * �����double
 * 
 * �����
 * �ܼۣ�double
 * ���㣺double	---1.��������ڵ����ܼۣ����㣩
 * 			  				---2.������С���ܼۣ���ʾ���㣩
 * 
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��Ʒ���ۣ�");
		double price=sc.nextDouble();
		System.out.println("��Ʒ������");
		double number=sc.nextDouble();
		double sum=price*number;
		System.out.println("��Ʒ�ܼۣ�"+sum);
		if(sum>=500) {//�ܼ۴��ڵ���500--����
			double losSum=sum*0.8;
			System.out.println("�ܼ�����500Ԫ�����ܰ����Żݺ�۸�Ϊ��"+losSum);
			System.out.println("�븶�");
			double money=sc.nextDouble();
			if(money>=losSum) {//��������ڵ����Żݺ��ܼ�----����
				System.out.println("���㣺"+(money-losSum));
			}else {//������С���Żݺ��ܼ�----��ʾ����
				System.out.println("����");
			}
			
		}else {//ԭ��
			System.out.println("�ܼ�δ����500Ԫ�������ܰ����Żݺ�۸�Ϊ��"+sum);
			System.out.println("�븶�");
			double money=sc.nextDouble();
			if(money>=sum) {//��������ڵ����Żݺ��ܼ�----����
				System.out.println("���㣺"+(money-sum));
			}else {//������С���Żݺ��ܼ�----��ʾ����
				System.out.println("����");
			}
		}
		
		
		
		
		
		
		
		
	}

}























































