package com.xms.basic.day05.p;

import java.util.Arrays;
import java.util.Random;

/**
 * 
0.�����������鶨��ķ�ʽ,������������,���鳤�ȷֱ�Ϊ5,6,7
���ú������������ڶ���ͬʱ��ʼ��,��һ���������0-11[0,11)����,��ֵ��������
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		int[] arr=new int[5];
		Random rd=new Random();
		for(int i=0;i<arr.length;i++) {
			int a=rd.nextInt(11);
			arr[i]=a;
		}
		//��ӡ����
		System.out.println(Arrays.toString(arr));
		
		int[] arr1=new int[] {1,2,3,4,5,6};
		int[] arr2={1,2,3,4,5,6,7};
		
		
	}

}





































