package com.xms.se.day09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 集合：将非线程安全的变成线程安全
 * @author deo
 *
 */
public class Demo08Thread {
public static void main(String[] args) {
	List<String> list=new ArrayList<String>();
	Set<String> set=new HashSet<String>();
	Map<String,Integer> map=new HashMap<String,Integer>();
	//Collections中方法,非安全变成安全
	Collections.synchronizedList(list);
	Collections.synchronizedSet(set);
	Collections.synchronizedMap(map);
}
}
