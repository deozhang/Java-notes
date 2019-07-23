package com.xms.basic.day05.p;
/**
 * 找出数组中元素最大值
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		int[] arr=new int[] {20,30,10,60,50};
		//1.假设法
		/*
		 * 假设int max=arr[0]为最大值
		 */
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max<=arr[i]) {
				max=arr[i];
			}
		}
		System.out.println("max="+max);
		//2.数组中两两对比，将最大值放在最后一位
		for(int i=0;i<arr.length-1;i++) {
			//定义比较规则
			if(arr[i]>arr[i+1]) {
				//调换位置
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			
		}
		System.out.println(arr[arr.length-1]);
		
	}

}





















