package com.xms.basic.day06;

import java.util.Scanner;

public class day20 {
	public static void main(String[]args) {
		
	Scanner sc=new Scanner(System.in);
	int i=sc.nextInt();
	int j=sum(i);
	System.out.println(j);
	}
	public static int sum(int a) {
		int sum=0;
		if(a==1) {
			return 1;
		}else {
			sum+=a;
			a--;
		}
		return sum;
		
	}

}

