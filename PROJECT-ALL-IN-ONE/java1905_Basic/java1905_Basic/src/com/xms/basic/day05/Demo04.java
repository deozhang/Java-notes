package com.xms.basic.day05;

import java.util.Arrays;

/**
 * ð��������������
 * 	���õķ��������ϸ����͡��²㡱
 * 	��ʩ����һ���ҳ�����Ԫ�ص����ֵ���������һλ�����ٱ䶯
 * 			  �ڶ�������ʣ��Ԫ���������ֵ�����ڵ����ڶ���λ�ã����ٱ䶯
 * 			 ��ÿ�αȽ�����ֻ�У��´αȽ������ʱ����һ��Ԫ�رȽϣ�
 * 			 �Դ�����
 * 
 * ð�ݣ����ݽ����Ĵ�����  6
 * 			��༸�Σ�5+4+3+2+1=15
 * 			���ٶ��ٴΣ�0
 * 6 5 4 3 2 1
 * 5
 * 4
 * 3
 * 2
 * 1
 * 1 2 3 4 5 6
 * 	
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		int[] arr= {11,20,10,60,30,12};
//		for(int j=0;j<arr.length-1;j++) {//��Ҫ���м��ֲ���
//			for(int i=0;i<arr.length-1-j;i++) {//ÿ�ֵĲ���--ѡ�����ֵ
//				//�ȽϹ���
//				if(arr[i]>arr[i+1]) {
//					//��λ��
//					int temp=arr[i];
//					arr[i]=arr[i+1];
//					arr[i+1]=temp;
//				}
//			}
//		}
		Arrays.sort(arr);//ָ�����������������
		System.out.println(Arrays.toString(arr));
	}

}






































