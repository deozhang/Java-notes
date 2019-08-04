package com.xms.basic.day05;

import java.util.Arrays;

/**
 * 数组的复制
 * 1.arraycopy
 * 调用方式:
 * 				System.arraycopy(Object src,
					int srcPos, Object dest, int destPos,int length);
		src:源数组
		srcPos:源数组的起始位置
 * 		dest:目标数组
 * 		destPos:目标数组起始位置
 * 		length:要复制的源数组的元素的长度
 * 		int[] arr={20,30,40,50,60}
 * 		int[] arr1=new int[5];
 * 		     --20,30,40,50,0
 * 
 * 
 * 2.copyOf
 * 		调用方式：
 * 				类型[] newArray = Arrays.copyOf(类型[] arr, int newLength);
				newArray：新的数组名
				arr：源数组
				newLength:新数组的长度
 * 
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		int[] arr= {20,30,40,50,60};
		int[] arr1=new int[5];//0,0,0,0,0--->20,30,40,50,0
		/*
		 * 注意参数：防止数组下标越界
		 * ArrayIndexOutOfBoundsException
		 */
		System.arraycopy(arr,1, arr1, 1, 4);
		System.out.println(Arrays.toString(arr1));
		System.out.println("------------------------------------------------");
		/**
		 * 所谓的数组“扩容”和数组“缩容”只是一种表面现象，实际
		 * 上该方法是在内存中开辟新的空间来存储对应的数组元素，只是
		 * 	恰好该空间名和源数组定义的空间名一致，形成所谓的数组“扩容”
		 * 和“缩容”-----其实是两个不同的存储空间，恰好名字相同，变量
		 *						    覆盖
		 */
		//目标数组长度大于源数组长度---数组“扩容”
		//---将源数组中的所有元素复制到目标数组中，多余的部分补充数组类型的默认值
		arr=Arrays.copyOf(arr, 6);
		System.out.println(Arrays.toString(arr));
		//目标数组长度小于源数长度--数组“缩容”
		//从目标数组中截取前newLength个元素复制到目标数组中
		arr=Arrays.copyOf(arr, 4);
		System.out.println(Arrays.toString(arr));
		
	}

}




































