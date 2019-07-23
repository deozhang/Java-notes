package com.xms.basic.day05.p;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 8.某公司采用共用电话传输数据，数据是四位数，在传递过程中是加密的，
加密规则如下；每位数字都加上5，然后用和除以10的余数代替该数，再
将第一位和第四位交换，第二位和第三位交换。
 * @author Administrator
 *
 */
public class Demo10 {
	public static void main(String[] args) {
		int[] arr=new int[4];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println("请输入第"+(i+1)+"位密码");
			int a=sc.nextInt();
			arr[i]=(a+5)%10;
		}
		System.out.println(Arrays.toString(arr));
		
		//换位置
		for(int i=0;i<arr.length/2;i++) {
			int temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
			
		}
		System.out.println(Arrays.toString(arr));
		
	}

}











