package com.xms.basic.day05.p;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 8.ĳ��˾���ù��õ绰�������ݣ���������λ�����ڴ��ݹ������Ǽ��ܵģ�
���ܹ������£�ÿλ���ֶ�����5��Ȼ���úͳ���10�����������������
����һλ�͵���λ�������ڶ�λ�͵���λ������
 * @author Administrator
 *
 */
public class Demo10 {
	public static void main(String[] args) {
		int[] arr=new int[4];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println("�������"+(i+1)+"λ����");
			int a=sc.nextInt();
			arr[i]=(a+5)%10;
		}
		System.out.println(Arrays.toString(arr));
		
		//��λ��
		for(int i=0;i<arr.length/2;i++) {
			int temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
			
		}
		System.out.println(Arrays.toString(arr));
		
	}

}











