package com.xms.basic.day09_1;

import com.xms.basic.day09.Demo02;

/**
 * 和day09.Demo02是跨包子类
 * @author Administrator
 *
 */
public class Demo06 extends Demo02 {
	public void methodDemo06() {
//		Demo02 d=new Demo02();
		//需要使用子类类型的引用取调用跨包子类---protected
		Demo06 d=new Demo06();
		System.out.println(d.a);
		System.out.println(d.b);
//		System.out.println(d.c);
//		System.out.println(d.d);
		//默认为当前对象的引用--Demo06
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
	}

}
