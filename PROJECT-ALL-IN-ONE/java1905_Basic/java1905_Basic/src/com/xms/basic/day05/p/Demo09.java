package com.xms.basic.day05.p;

import java.util.Arrays;

/**
 * 
7.已知一个数组arr，将奇数元素存到arrj数组中，偶数元素存到arro数组中。
  思路：
  		1.先求出arr数组中奇数元素的个数/偶数元素个数
  		2.定义奇数数组/偶数数组
  		3.将arr数组中，奇数元素放入奇数数组中
  								 偶数元素放入偶数数组中
  								 注意:
  								 		奇数元素/偶数 元素数组下标都是从0开始

 * @author Administrator
 *
 */
public class Demo09 {
	public static void main(String[] args) {
		int[] arr=new int[] {1,2,3,4,5,6,7,8,9};
		//1.计算偶数或者奇数元素的个数
		int n=0;//计数器
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {//偶数
				n++;
			}
		}
		//2.定义对应的数组
		int[] arrj=new int[arr.length-n];
		int[] arro=new int[n];
		//3.将对应的元素放入对应的数组中
		//注意：下标
		int o=0;//偶数下标
		int j=0;//奇数下标
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {//偶数元素
				arro[o++]=arr[i];
			}else {///奇数元素
				arrj[j++]=arr[i];
			}
			
		}
		System.out.println(Arrays.toString(arro));
		System.out.println(Arrays.toString(arrj));
	}
	

}




















































