package com.xms.basic.day05.p;

import java.util.Arrays;
import java.util.Random;

/**
 * 
0.利用三种数组定义的方式,定义三个数组,数组长度分别为5,6,7
利用后面两种数组在定义同时初始化,第一种随机产生0-11[0,11)的数,赋值给该数组
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		int[] arr=new int[5];
		Random rd=new Random();
		for(int i=0;i<arr.length;i++) {
			int a=rd.nextInt(11);
			arr[i]=a;
		}
		//打印数组
		System.out.println(Arrays.toString(arr));
		
		int[] arr1=new int[] {1,2,3,4,5,6};
		int[] arr2={1,2,3,4,5,6,7};
		
		
	}

}





































