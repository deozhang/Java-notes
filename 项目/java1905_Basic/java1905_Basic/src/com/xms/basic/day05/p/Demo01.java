package com.xms.basic.day05.p;
/**
 * �ҳ�������Ԫ�����ֵ
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		int[] arr=new int[] {20,30,10,60,50};
		//1.���跨
		/*
		 * ����int max=arr[0]Ϊ���ֵ
		 */
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max<=arr[i]) {
				max=arr[i];
			}
		}
		System.out.println("max="+max);
		//2.�����������Աȣ������ֵ�������һλ
		for(int i=0;i<arr.length-1;i++) {
			//����ȽϹ���
			if(arr[i]>arr[i+1]) {
				//����λ��
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			
		}
		System.out.println(arr[arr.length-1]);
		
	}

}





















