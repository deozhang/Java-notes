package com.xms.basic.day05.p;

import java.util.Arrays;
import java.util.Random;

/**
 * 10.�������7λ���ظ���int���͵����� [0,10]

 * @author Administrator
 *
 */
public class Demo12 {
	public static void main(String[] args) {
		int[] arr=new int[7];
		Random  rd=new Random();
		boolean[] b=new boolean[11];
		for(int i=0;i<arr.length;i++) {
			while(true) {
				int a=rd.nextInt(11);
				if(b[a]==false) {
					arr[i]=a;
					b[a]=true;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}





