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
		map.put("����", 88);
		map.put("��ѧ", 99);
		map.put("Ӣ��", 88);
		map.put("����", 77);
		map.put("��ѧ", 66);
		map.put("����", 55);	
//		�������е�key set(key) keyset();
		Set<String> keys =map.keySet();
		for(String s : keys) {
			System.out.println(s);
		}
		
		System.out.println("---������Key-Value��----------------------------------");
		/*
		 * 2.�������е�Key-Value
		 * Set<Entry<K,V>>   entrySet():
		 * �÷����Ὣÿһ��K-V��Ϊһ��Entryʵ�����뵽
		 * Set������
		 * 
		 * ����Set���ϣ�������������Key-Value
		 * ͨ��Entry��ķ�����ȡEntry�����K��Vֵ
		 */
		Set<Entry<String,Integer>> entrys=map.entrySet();
		for (Entry<String, Integer> entry : entrys) {
			/*
			 * ����Entry��ķ���:
			 * getKey():��ȡEntry�����Keyֵ
			 * getValue():��ȡEntry�����Valueֵ
			 */
//			String key=entry.getKey();
//			Integer value=entry.getValue();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key+":"+value);
		}
		/*
		 * Collection<T> values():
		 * �÷�����ȡMap�������е�Vֵ
		 * ��������Ӧ���͵�Collection������
		 * �����ü��ϣ����������е�Valueֵ
		 */
		Collection<Integer> ss =map.values();
		for(Integer a :ss) {
			System.out.println(ss);
		}
	}

}






























