package com.xms.basic.day05;

import java.util.Arrays;

/**
 * ����ĸ���
 * 1.arraycopy
 * ���÷�ʽ:
 * 				System.arraycopy(Object src,
					int srcPos, Object dest, int destPos,int length);
		src:Դ����
		srcPos:Դ�������ʼλ��
 * 		dest:Ŀ������
 * 		destPos:Ŀ��������ʼλ��
 * 		length:Ҫ���Ƶ�Դ�����Ԫ�صĳ���
 * 		int[] arr={20,30,40,50,60}
 * 		int[] arr1=new int[5];
 * 		     --20,30,40,50,0
 * 
 * 
 * 2.copyOf
 * 		���÷�ʽ��
 * 				����[] newArray = Arrays.copyOf(����[] arr, int newLength);
				newArray���µ�������
				arr��Դ����
				newLength:������ĳ���
 * 
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		int[] arr= {20,30,40,50,60};
		int[] arr1=new int[5];//0,0,0,0,0--->20,30,40,50,0
		/*
		 * ע���������ֹ�����±�Խ��
		 * ArrayIndexOutOfBoundsException
		 */
		System.arraycopy(arr,1, arr1, 1, 4);
		System.out.println(Arrays.toString(arr1));
		System.out.println("------------------------------------------------");
		/**
		 * ��ν�����顰���ݡ������顰���ݡ�ֻ��һ�ֱ�������ʵ��
		 * �ϸ÷��������ڴ��п����µĿռ����洢��Ӧ������Ԫ�أ�ֻ��
		 * 	ǡ�øÿռ�����Դ���鶨��Ŀռ���һ�£��γ���ν�����顰���ݡ�
		 * �͡����ݡ�-----��ʵ��������ͬ�Ĵ洢�ռ䣬ǡ��������ͬ������
		 *						    ����
		 */
		//Ŀ�����鳤�ȴ���Դ���鳤��---���顰���ݡ�
		//---��Դ�����е�����Ԫ�ظ��Ƶ�Ŀ�������У�����Ĳ��ֲ����������͵�Ĭ��ֵ
		arr=Arrays.copyOf(arr, 6);
		System.out.println(Arrays.toString(arr));
		//Ŀ�����鳤��С��Դ������--���顰���ݡ�
		//��Ŀ�������н�ȡǰnewLength��Ԫ�ظ��Ƶ�Ŀ��������
		arr=Arrays.copyOf(arr, 4);
		System.out.println(Arrays.toString(arr));
		
	}

}




































