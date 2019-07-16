package com.xms.basic.day05;

import java.util.Arrays;

/**
 * 冒泡排序：升序排序
 * 	采用的方法：“上浮”和“下层”
 * 	措施：第一次找出所有元素的最大值，放在最后一位，不再变动
 * 			  第二次再在剩余元素中找最大值，放在倒数第二的位置，不再变动
 * 			 （每次比较排序只有，下次比较排序的时候少一个元素比较）
 * 			 以此类推
 * 
 * 冒泡：数据交换的次数，  6
 * 			最多几次？5+4+3+2+1=15
 * 			最少多少次？0
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
//		for(int j=0;j<arr.length-1;j++) {//需要进行几轮操作
//			for(int i=0;i<arr.length-1-j;i++) {//每轮的操作--选出最大值
//				//比较规则
//				if(arr[i]>arr[i+1]) {
//					//换位置
//					int temp=arr[i];
//					arr[i]=arr[i+1];
//					arr[i+1]=temp;
//				}
//			}
//		}
		Arrays.sort(arr);//指定数组进行升序排序
		System.out.println(Arrays.toString(arr));
	}

}






































