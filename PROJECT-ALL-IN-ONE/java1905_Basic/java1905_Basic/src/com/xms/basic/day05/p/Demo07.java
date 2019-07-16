package com.xms.basic.day05.p;

import java.util.Arrays;

/**
 * 5.已知一个数组，将所有元素乘二。
 * @author Administrator
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		int[] arr= {1,2,3};
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr[i]*2;
		}
		System.out.println(Arrays.toString(arr));
	}

}












