package com.xms.se.day03;

import java.util.*;


/**
 * java内部给我们提供了集合类，该类的实例可以存储任何类型的对象，存储空间的大小
 * 可以动态改变，随着元素的增减而扩大和缩小
 * 
 * 集合的由来：
 * 		数组：数组一旦定义不可更改，当元素超过了定义的空间大小，就需要重新定义数组
 * 				只能存储相同类型的元素
 * 		集合：新的数据结构，可以保存不同类型的元素，且空间大小可以动态增减。
 * 
 * 数据与集合的区别：
 * 				1.数据既可以存储基本类型的数据，也可以存储引用类型的数据
 * 					基本类型数组存储的是值，引用类型数组存储的是地址值
 * 				2.集合只能存储引用类型的数据，存储的是地址值
 * 				3.数组的长度是定长，不能动态增减
 * 				  集合的长度是不定的，可以随着元素改变而增减
 * 
 * 应用场景：
 * 		1.如果数据量是一定的，推荐使用数组
 * 		2.如果数据量是不定的，推荐使用集合
 * 
 * 集合的继承体系：
 * 		父接口--Collection：
 * 			子接口：
 * 			List(list集合):--有序集合，可重复，存取都是按照顺序来的
 * 				实现类：
 * 				Arraylist:数组结构
 * 				LinkedList:链表结构
 * 			Set(set集合):--无序集合（部分有序），不可重复，存取没有顺序
 * 				实现类：
 * 				HashSet:哈希算法
 * 				TreeSet:二叉树算法
 * 集合的基本功能
 * 			boolean add(E e):添加一个元素到集合中
 * 			boolean remove(Object o):删除一个元素到集合中
 * 			boolean contains(Object o):判断集合中是否包含指定元素
 * 			boolean isEmpty():判断集合是不是空
 * 			int size():获取集合的大小
 * 			void clear():将集合清空（全部删除）
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo04Collection {
	public static void method1() {
		//创建集合实例
		Collection c=new ArrayList();
		//向集合中添加元素---集合中只存储引用类型数据
		c.add("a");//引用类型
		c.add("b");//引用类型
		c.add(1);//自动装箱---引用类型
		c.add(2);//自动装箱---引用类型
		c.add(1);//自动装箱---引用类型
		c.add(4);//自动装箱---引用类型
		
		System.out.println(c);
		System.out.println("集合的大小："+c.size());//获取集合的大小
		
		/*
		 * remove(Object o):
		 * 返回值为boolean类型
		 * true：
		 * false:
		 * 删除集合中指定的元素，删除的是从头到尾最先匹配到的数据
		 * 判断相同使用的方法为equals()
		 * 返回值为true时移除元素
		 */
		
		//集合中不存在的
		boolean bo1=c.remove(6);
		System.out.println("bo1:"+bo1);
		boolean bo2=c.remove(1);
		System.out.println("bo2:"+bo2);
		System.out.println(c);
		
		/*
		 * contains(Object o):
		 * 判断集合中是否包含指定元素
		 * 返回值为布尔类型，返回值为true 包含
		 * 
		 * 判断是否包含使用equals方法
		 * 包含就是true 不包含就返回false
		 */
		boolean bo4=c.contains("a");
		System.out.println("bo4:"+bo4);
		boolean bo5=c.contains("c");
		System.out.println("bo5:"+bo5);
		
		/*
		 * isEmpty():
		 * 判断一个集合是不是 空
		 * 如果是空，返回true，不是返回false
		 * 
		 * clear():
		 * 将集合进行清除（删除所有元素）
		 * 无返回值
		 */
		boolean bo6=c.isEmpty();
		System.out.println("bo6:"+bo6);
		c.clear();
		boolean bo7=c.isEmpty();
		System.out.println("bo7:"+bo7);
		
	}
	
	public static void method2() {
		/**
		 * 集合的批量操作
		 * 		boolean addAll(Collection c):添加一个集合
		 * 		boolean removeAll(Collection c):删除一个集合
		 * 		boolean containsAll(Collection c):是否包含指定集合
		 * 		
		 */
		Collection c1=new ArrayList();
		c1.add(1);
		c1.add(2);
		Collection c2=new ArrayList();
		c2.add(3);
		c2.add(4);
		Collection c3=new ArrayList();
		c3.add(5);
		c3.add(6);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//将c2添加到c1中
		c1.addAll(c2);//如果写成add   会变成二维集合
		System.out.println("--------------------------");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//判断c1集合中是否包含c2   c1需要包含c2的所有元素才算包含
		boolean bo1=c1.containsAll(c2);
		boolean bo2=c1.containsAll(c3);
		System.out.println("--------------------------");
		System.out.println("bo1:"+bo1);
		System.out.println("bo2:"+bo2);
		
		//删除一个集合 
		/*
		 * 返回值为布尔类型,
		 * 如果返回值为true，表示删除成功
		 * 如果返回值为false，表示删除失败
		 * 
		 */
		boolean bo3=c1.removeAll(c2);
		boolean bo4=c1.removeAll(c3);
		System.out.println("--------------------------");
		System.out.println("bo3:"+bo3);
		System.out.println("bo4:"+bo4);
		
		
	}
	public static void main(String args[]) {
//		method1();
		method2();
	}
}
