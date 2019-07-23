package com.xms.basic.day04;

import java.util.Scanner;

/**
 * 收银程序
 * 
 * 输入：
 * 单价:double
 * 数量：double
 * 付款金额：double
 * 
 * 输出：
 * 总价：double
 * 找零：double	---1.付款金额大于等于总价（找零）
 * 			  				---2.付款金额小于总价（提示金额不足）
 * 
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("商品单价：");
		double price=sc.nextDouble();
		System.out.println("商品数量：");
		double number=sc.nextDouble();
		double sum=price*number;
		System.out.println("商品总价："+sum);
		if(sum>=500) {//总价大于等于500--八折
			double losSum=sum*0.8;
			System.out.println("总价满足500元，享受八折优惠后价格为："+losSum);
			System.out.println("请付款：");
			double money=sc.nextDouble();
			if(money>=losSum) {//付款金额大于等于优惠后总价----找零
				System.out.println("找零："+(money-losSum));
			}else {//付款金额小于优惠后总价----提示金额不足
				System.out.println("金额不足");
			}
			
		}else {//原价
			System.out.println("总价未满足500元，不享受八折优惠后价格为："+sum);
			System.out.println("请付款：");
			double money=sc.nextDouble();
			if(money>=sum) {//付款金额大于等于优惠后总价----找零
				System.out.println("找零："+(money-sum));
			}else {//付款金额小于优惠后总价----提示金额不足
				System.out.println("金额不足");
			}
		}
		
		
		
		
		
		
		
		
	}

}























































