package com.xms.basic.day05.p;

import java.util.Arrays;

/**
 * 6.已知一个数组，将所有元素加到第一个元素中。
 * @author Administrator
 *
 */
public class Demo08 {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		for(int i=1;i<arr.length;i++) {
			arr[0]+=arr[i];//arr[0]=arr[0]+arr[i];
		}
		System.out.println(Arrays.toString(arr));
		
	}

}
