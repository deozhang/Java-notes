package com.xms.basic.day05;

import java.util.Arrays;

/**
 * ��������ʵ�������ڴ��п��ٶ�Ӧ�Ĵ洢�ռ�
 * --����һ�����岻�ɸ��ģ��������ͣ�����Ŀռ��С��
 * 
 * ����Ĳ���:
 * 		1.��ȡ����ĳ��ȣ��ռ�Ĵ�С��Ԫ�صĸ�����
 * 			�﷨���������͵�ֵ=������.length;
 * 		2.��ȡ������ĳ��Ԫ�ص�ֵ
 * 			�﷨��������[index]
 * 			index:0~������.length-1���±꣩
 * 		3.������Ԫ�ظ�ֵ/�޸�ֵ
 * 			�﷨��������[index]=ֵ��������������ͣ�
 * 			index:0~������.length-1���±꣩
 * 		4.����ı���
 * 			һ���Ǵ���forѭ����������ı���
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		int[] arr=new int[10];
		System.out.println(Arrays.toString(arr));
		//1.��ȡ����ĳ���
		int len=arr.length;
		System.out.println(len);
		/*
		 * ͨ���±��������ʱ��ע���±귶Χ
		 * ArrayIndexOutOfBoundsException��
		 * ---�����±�Խ��
		 */
		int[] arr1=new int[] {20,30,40,50};
		//2.��ȡ������ĳ��Ԫ�ص�ֵ
		int a=arr1[2];
		System.out.println("a="+a);
		//3.������Ԫ�ظ�ֵ/�޸�ֵ
		int[] arr2= {20,30,40,50,60};
		arr2[2]=60;
		System.out.println(Arrays.toString(arr2));
		//4.����ı���
		for(int i=0;i<arr2.length;i++) {
			int num=arr2[i];
			arr2[i]=arr2[i]+2;
			System.out.println(num);
		}
		System.out.println(Arrays.toString(arr2));
		
		
	}

}





















