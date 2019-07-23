package com.xms.basic.day05;

import java.util.Arrays;

/**
 * 定义数组实际上是内存中开辟对应的存储空间
 * --数组一旦定义不可更改（数组类型，数组的空间大小）
 * 
 * 数组的操作:
 * 		1.获取数组的长度（空间的大小，元素的个数）
 * 			语法：整数类型的值=数组名.length;
 * 		2.获取数组中某个元素的值
 * 			语法：数组名[index]
 * 			index:0~数组名.length-1（下标）
 * 		3.给数组元素赋值/修改值
 * 			语法：数组名[index]=值（符合数组的类型）
 * 			index:0~数组名.length-1（下标）
 * 		4.数组的遍历
 * 			一般是搭配for循环进行数组的遍历
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		int[] arr=new int[10];
		System.out.println(Arrays.toString(arr));
		//1.获取数组的长度
		int len=arr.length;
		System.out.println(len);
		/*
		 * 通过下标操作数组时，注意下标范围
		 * ArrayIndexOutOfBoundsException：
		 * ---数组下标越界
		 */
		int[] arr1=new int[] {20,30,40,50};
		//2.获取数组中某个元素的值
		int a=arr1[2];
		System.out.println("a="+a);
		//3.给数组元素赋值/修改值
		int[] arr2= {20,30,40,50,60};
		arr2[2]=60;
		System.out.println(Arrays.toString(arr2));
		//4.数组的遍历
		for(int i=0;i<arr2.length;i++) {
			int num=arr2[i];
			arr2[i]=arr2[i]+2;
			System.out.println(num);
		}
		System.out.println(Arrays.toString(arr2));
		
		
	}

}





















