package com.xms.basic.day05.p;

import java.util.Arrays;

/**
 * 9.��������Ϊ0��Ԫ��ȥ����Ȼ��ȥ��0��������Ԫ�����·ŵ�һ���µ�������
 * ���裺
 * 	1.�����Ϊ��Ԫ���м�λ
 * 	2.���岻Ϊ0Ԫ�ص�����
 * 3.����Ϊ0��Ԫ�ط����������
 * @author Administrator
 *
 */
public class Demo11 {
	public static void main(String[] args) {
		int[] arr= {1,0,2,13,0,4,51,0};
		int n=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				n++;	
			}
		}
		int[] arrNew=new int[n];
		int notZore=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				arrNew[notZore++]=arr[i];
			}
		}
		System.out.println(Arrays.toString(arrNew));
		
	}

}





