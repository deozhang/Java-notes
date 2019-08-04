package com.xms.basic.day05.p;
/**
 * 4.已知一个数组，输出所有元素中，值为奇数的。 
 * @author Administrator
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7};
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2!=0) {
				System.out.println(arr[i]);
			}
			
		}
	}

}
