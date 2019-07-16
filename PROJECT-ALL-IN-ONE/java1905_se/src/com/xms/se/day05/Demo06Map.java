package com.xms.se.day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo06Map {
	private static Object entry;

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("语文", 88);
		map.put("数学", 99);
		map.put("英语", 88);
		map.put("物理", 77);
		map.put("化学", 66);
		map.put("生物", 55);	
//		遍历所有的key set(key) keyset();
		Set<String> keys =map.keySet();
		for(String s : keys) {
			System.out.println(s);
		}
		
		System.out.println("---遍历（Key-Value）----------------------------------");
		/*
		 * 2.遍历所有的Key-Value
		 * Set<Entry<K,V>>   entrySet():
		 * 该方法会将每一组K-V做为一个Entry实例存入到
		 * Set集合中
		 * 
		 * 遍历Set集合，即遍历所有是Key-Value
		 * 通过Entry类的方法获取Entry对象的K和V值
		 */
		Set<Entry<String,Integer>> entrys=map.entrySet();
		for (Entry<String, Integer> entry : entrys) {
			/*
			 * 属于Entry类的方法:
			 * getKey():获取Entry对象的Key值
			 * getValue():获取Entry对象的Value值
			 */
//			String key=entry.getKey();
//			Integer value=entry.getValue();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key+":"+value);
		}
		/*
		 * Collection<T> values():
		 * 该方法获取Map集合所有的V值
		 * 将其存入对应泛型的Collection集合中
		 * 遍历该集合，即遍历所有的Value值
		 */
		Collection<Integer> ss =map.values();
		for(Integer a :ss) {
			System.out.println(ss);
		}
	}

}






























