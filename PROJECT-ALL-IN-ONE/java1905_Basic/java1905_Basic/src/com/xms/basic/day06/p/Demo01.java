package com.xms.basic.day06.p;

import java.util.Arrays;
import java.util.Random;

/**
 * 练习
 * @author Administrator
 *
 */
public class Demo01 {
	//1.封装一个方法输出"今天是一个好日子"
	public static void method1() {
		System.out.println("今天是一个好日子");
	}
	//2.封装一个方法，能够随机产生指定长度的int类型的数组[0-100]
	public static int[] method2(int length) {
		int[] arr=new int[length];
		Random rd=new Random();
		for(int i=0;i<arr.length;i++) {
			int a=rd.nextInt(101);
			arr[i]=a;
		}
		return arr;
	}
	//3.封装一个方法，能够找出int类型数组的最小值
	public static int method3(int[] arr) {
		//假设法
		int min=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(min>arr[i]) {
				min=arr[i];
			}
		}
		return min;
	}
	//4.封装一个方法，可以将指定的int类型数组，降序排序
	public static int[] method4(int[] arr) {
		//方法中可以调用方法
		/*
		 * 1.先将指定数组进行升序排序
		 * 2.然后将对应位置调换
		 */
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length/2;i++) {
			int temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
			
		}
		return arr;
		
	}
	
	//5.封装一个方法，可以求指定int数组中所有元素的和
	public static int method5(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
		}
		return sum;
	}
	
//6.封装一个方法，判断两个int类型的数组是否相等，
//	如果相等，则返回值结果为true，如果不等则返回为false
	public static boolean method6(int[] arr1,int[] arr2) {
		/*
		 * 1.优先判断数组长度是否相等
		 * 				---长度相等
		 * 						判断对应位置上的元素值相等--true
		 * 						判断对应位置上的元素值不相等--false
		 * 				--长度不等
		 * 						--不用判断元素值--false
		 */
		boolean flag=true;//开关
		if(arr1.length==arr2.length) {//长度相等
			for(int i=0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					flag=false;
					break;
				}
				
			}
			return flag;
		}else {//长度不等
			return !flag;
		}
	}
	//7.封装一个方法，能否计算两个int类型正整数之间所有数字的和
	//如：2,6
	//2+3+4+5+6==？
	public static int method7(int a,int b) {
		int sum=0;
		if(a>=b) {//a>=b
			for(int i=b;i<=a;i++) {
				sum=sum+i;
			}
		}else {//a<b
			for(int i=a;i<=b;i++) {
				sum=sum+i;
			}
		}
		return sum;
		
	}
	
	//8.将指定的int类型数插入到指定的int类型数组中的指定位置
	/*
	 * 1,2,3,4,5
	 * 
	 * 0  arr  1
	 * --->
	 * 1,0,2,3,4,5
	 * 分析：
	 * 1.数组扩容  长度增加1
	 * 2.将源数组中的元素，赋值给新的 数组中，错位赋值
	 * 
	 * 
	 * 
	 * 123450-->12 2345
	 * 
	 */
	public static int[] method8(int num,int[] arr,int index) {
		//数组复制
		int[] arrNew=Arrays.copyOf(arr, arr.length+1);
		for(int i=index;i<arr.length;i++) {
			arrNew[i+1]=arr[i];
		}
		arrNew[index]=num;
		return arrNew;
		
	}
	//9.封装一个方法，计算两个double的数字和
	public static double method9(double a,double b) {
		return a+b;
	}
	
	
}


















































