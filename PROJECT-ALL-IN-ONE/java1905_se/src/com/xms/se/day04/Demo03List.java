package com.xms.se.day04;

import java.util.*;

/**
 * List集合：有序可重复的集合
 * 				---元素的存储是有顺序（通过下标操作元素）
 * 				---里面可以存放重复的元素
 * 			ArrayList:数组结构---数组实现的（元素的检索与查询效率较高）
 * 					数组是最基本的数据结构：是使用一块连续的内存区域存储数据
 * 					保存数据的个数在分配空间时就已经确定
 * 			linkedList:链表结构---链表实现的（元素的插入和删除效率较高）
 * 					链表是在非连续的内存单元中保存，并且通过指针将各个内存单元
 *					连接在一起，链表是不需要提前分配固定大小的存储空间，当需要
 *					存储数据的时候，分配一块内存将数据存入内存中，用指针将其插入
 *					到链表中
 *
 *					节点:数据区和指针区域
 *					链表就是把各个节点连起来
 * @author Administrator
 *
 */
public class Demo03List {
	public static void method1() {
		//创建List集合--泛型（String ）
		List<String> list=new ArrayList<String>();
		list.add("a");//0
		list.add("b");//1
		list.add("c");//2
		list.add("d");//3
		list.add("e");//4
		System.out.println(list);
		System.out.println(list.size());
		System.out.println("--s1---------------------");
		/*
		 * get(int index):index--表示下标（0~size()-1）
		 * 该方法通过下标获取对应位置上的元素
		 * 返回值为对应集合泛型（集合存储的是什么类型的元素，返回值就是什么类型）
		 * 注意：下标越界
		 */
		String s1=list.get(0);
		System.out.println("s1:"+s1);
		//传统for循环遍历集合
		for(int i=0;i<list.size();i++) {
			String str=list.get(i);
			System.out.println(str);
		}
		System.out.println("--s2---------------------");
		
		/*
		 * set(int index,<T>t):
		 * 使用t元素替换掉index位置上的元素
		 * 返回值为被替换掉的元素值（集合泛型）
		 * 
		 */
		String s2=list.set(0, "A");
		System.out.println("s2:"+s2);
		System.out.println(list);
		System.out.println("--s3---------------------");
		
		/*
		 * add(int index,<T> t):
		 * 将给定的元素t，插入到index位置上，
		 * index位置上原有的元素及后续元素依次向后移动
		 * ----void
		 */
		list.add(1, "B");
		System.out.println(list);
		System.out.println("--s4---------------------");
		/*
		 * remove(int index):
		 * 移除指定位置上的元素值
		 * 返回值为对应泛型被移除的元素
		 */
		String s3=list.remove(2);
		System.out.println("s3:"+s3);
		System.out.println(list);
		System.out.println("-------------------------");
		
	}
	public static void method2() {
		/*
		 * 如果子集发生变量，原集合对应位置 也会发生变化（地址值是相同的）
		 */
		List<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<20;i++) {
			list.add(i);
		}
		System.out.println(list);
		System.out.println("-------------------------");
		List<Integer> listNew=list.subList(6, 17);
		System.out.println(listNew);
		System.out.println("-------------------------");
		//将截取的子集每个元素扩大十倍
		for(int i=0;i<listNew.size();i++) {
			listNew.set(i,listNew.get(i)*10);
		}
		System.out.println(listNew);
		System.out.println(list);
		
	}
	
	public static void method3() {
		/*
		 * 集合与数组之间的转换
		 * 集合转数组
		 * 		1.toArray():将List集合转换为Object类型的数组---使用较少
		 * 		2.toArray(new 引用类型[length]):将List集合转成自定义类型的数组
		 * 				1.length长度如果大于原集合大小，多余的部分补充null
		 * 				2.length长度如果小于原集合大小，系统会自己创建一个与原集合大小相等的存储空间，不再使用用户定义的
		 * 
		 */
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//将集合转成数组
		Object[] objArr=list.toArray();//几乎不用
		Integer[] inArr=list.toArray(new Integer[2]);
		System.out.println(Arrays.toString(inArr));
		
		/*
		 * 数组转List集合   通常不转Set集合  Set集合不可重复
		 * asList(类型[] arr):
		 * 将指定的数组转成List集合
		 * 返回值为对应泛型的List集合
		 */
		String[] strArr=new String[] {"a","b","c","d"};
		//数组转集合
		List<String> listOne=Arrays.asList(strArr);		
		/*
		 * 数组转成集合后，不能改变该集合中的元素
		 */
//		listOne.add("e");//不支持的操作
		System.out.println(listOne);	
		
	}
	
	public static void method4() {
		/*
		 * 集合的复制
		 * 
		 */
		String[] strArr=new String[] {"a","b","c","d"};
		//数组转集合
		List<String> listOne=Arrays.asList(strArr);		
		List<String> listTwo=new ArrayList<String>();
		//1.将数组转成的集合添加到新建的集合中---此时可以改变新集合的元素
		listTwo.addAll(listOne);
		listTwo.add("e");
		System.out.println(listTwo);
		//2.使用构造方法
		List<String> listThree=new ArrayList<String>(listOne);
		listThree.remove(3);
		System.out.println(listThree);
	}
	
	
	public static void main(String args[]) {
//		method1();
//		method2();
//		method3();
		method4();
	}

}
