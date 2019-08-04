package com.xms.basic.day05.p;

import java.util.Arrays;

/**
 * 
1.已知一个数组，求数组中心元素。
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		int[] arr=new int[] {1,2,3,4,5,6};
		if(arr.length%2==0) {//偶数
			System.out.println(arr[arr.length/2-1]);
			System.out.println(arr[arr.length/2]);
		}else {//奇数
			System.out.println(arr[arr.length/2]);
		}
	}

}
