package com.xms.se.day08;
/**
 * 异常:
 * Exception:代码逻辑出现问题(需要我们去处理)
 * 	Runtime-Exception:运行时异常,不一定捕获
 * 	NON-Runtime-Exception:非运行时异常,可捕获的
 * error:允许捕获,语法或者计算机硬件出现问题---必须处理
 * 
 * 	异常处理机制:(程序员处理异常的方法--欺骗计算机的一种行为)
 * 	1.捕获:try-catch
 * 	2.抛出:throws
 * 	所有的异常不要抛出给main方法,如果抛给main方法,程序会直接停止
 * 
 * @author deo
 *
 */
public class Demo02Exception {
	public static void main(String[] args) {
		try {
			/*
			 * 	有可能出现异常的代码放入try块中
			 * 	有可能出现的错误类型放到catch块中
			 * 
			 * 	try块中的代码从上到下开始执行,如果某段代码出现异常,\
			 * 	虚拟机会根据错误,创建该错误类型的对象,并到catch块
			 * 	从上到下开始遍历与之错误类型相同的catch,如果相同则会将
			 * 	该错误类型和错误信息输出,一旦try块某段代码出现异常,
			 * 	则该段代码和之后的代码不再执行,直接跳到catch块中遍历
			 * 	找到与之对应的错误类型后,整个try-catch结束,执行该
			 *	模块之下的有效代码
			 *
			 *	注意:catch中类型的大小关系为:(从上到下)从小到大
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}












