package com.xms.basic.day03.p;

import java.util.Scanner;

/***
 * ��3����ӡ�����Ϲ�������֯������Ļ��֣����ڿ���̨���
	0��17��Ϊδ������
	18��65��Ϊ������
	66��79��Ϊ������
	80��99��Ϊ������
	100���ϳ�������
 * @author Administrator
 *
 */
public class Demo03 {
	public  static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������������䣺");
		int age=sc.nextInt();
		if(age>0&&age<=17) {
			System.out.println("δ����");
		}else if(age>=18&&age<=65) {
			System.out.println("����");
		}else if(age>=65&&age<=79) {
			System.out.println("����");
		}else if(age>=80&&age<=99) {
			System.out.println("����");
		}else if(age>=100) {
			System.out.println("����");
		}
		
	}

}












































