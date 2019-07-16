package com.xms.basic.day05.p;

import java.util.Arrays;

/**
 * 9.将数组中为0的元素去除，然后将去除0后其他的元素重新放到一个新的数组中
 * 步骤：
 * 	1.求出不为的元素有几位
 * 	2.定义不为0元素的数组
 * 3.将不为0的元素放入该数组中
 * @author Administrator
 *
 */
public class Demo11 {
	public static void main(String[] args) {
		int[] arr= {1,0,2,13,0,4,51,0};
		int n=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				n++;	
			}
		}
		int[] arrNew=new int[n];
		int notZore=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				arrNew[notZore++]=arr[i];
			}
		}
		System.out.println(Arrays.toString(arrNew));
		
	}

}





