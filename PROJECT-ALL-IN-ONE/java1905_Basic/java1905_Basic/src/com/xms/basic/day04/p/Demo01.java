package com.xms.basic.day04.p;

import java.util.Scanner;

/**
 * 
11.����a+aa+aaa+aaaa+...��ֵ
a��ֵ�ͼ������λ�ӿ���̨����
Ҫ���ڿ�����ʾ����
 s=1+11+111+1111+..=?
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���������֣�");
		int a=sc.nextInt();
		System.out.println("���������ֵ�λ����");
		int b=sc.nextInt();
		/**
		 * 1.�����������ֵ�ֵ  1+11+111=?
		 * 2.ʹ���ַ���ƴ�ӣ�������Ч��
		 */
		int sum=0;//�������ֵĽ��
		int h=a;//ÿһλ���ֵ�ֵ
		int t=a;
		for(int i=1;i<=b;i++) {
			/**
			 * sum      		h        			a
			 * 1					11				10
			 * 1+11			100+11		100
			 * 1+11+111	1000+111	1000
			 */
			sum=sum+h;
			//Ϊ��һ�ε��������̵�
			h=a*10+h;
			a=a*10;
			
		}
		System.out.print("sum=");
		//2.ʹ���ַ���ƴ��
		for(int i=1;i<=b;i++) {//��
			//������
			for(int j=1;j<=i;j++) {//��
				//�е�����
				System.out.print(t);
			}
			if(i!=b) {
				System.out.print("+");
			}
		}
		System.out.print("="+sum);
		
		 
		
	}

}










































































