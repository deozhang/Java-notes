package com.xms.basic.day05;

import java.util.Arrays;

/**
 * 数组：相同数据类型的元素组成的集合（引用数据类型）
 * 			--（自动类型转换除外）
 * 	数据结构：按照线性顺序保存数据结构
 * 					前驱元素：第一个元素没有前驱元素
 * 					后继元素：最后一个元素没有后继元素
 * 数组中每一个元素都有对应的标识（下标），数组的下标
 * 是从0开始，到-1结束（操作数组都是通过下标）
 * 
 * 数组的定义：
 * 		1.确切的数据类型---表示能存储什么类型的数据
 * 		2.整体的数组名---给数组起一个变量名（引用变量）
 * 		3.数组的标识"[]"---"[]"表示数组
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		/*
		 * 定义一个数组，能存储多个int类型的数据--6
		 */
		//第一种
		/*
		 * 第一种定义数组的方式：强制在内存中开辟，对应类型的存储
		 * 空间，空间大小自定义。开辟后，对应的存储空间中存储着对应
		 * 数据类型的默认值
		 * 整数类型默认值：0
		 * 浮点类型默认值：0.0
		 * 字符类型默认值：\u0000
		 * 布尔类型的默认值：false
		 * 引用数据类型的默认值：null
		 * 
		 * 这种定义方式，不能在定义的同时初始化
		 * 
		 */
		//在内存中开辟对应类型的存储空间--new  强制操作（开辟空间）
		int a=12;
		int[] arr=new int[6];
		System.out.println(Arrays.toString(arr));
		boolean[] arr0=new boolean[3];
		System.out.println(Arrays.toString(arr0));
		/*
		 * 第二种定义数组的方式
		 */
		
		boolean[] arr1=new boolean[]{false,true};
		/*
		 * 第三种定义数组的方式
		 * 
		 */
		double[] arr2= {2.5,3.0,20.6};
		
		
	}

}




















































