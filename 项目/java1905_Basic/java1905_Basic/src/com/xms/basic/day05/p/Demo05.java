package com.xms.basic.day05.p;
/**
 * 3.��֪һ�����飬������������±�Ԫ�ء�
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		for(int i=1;i<arr.length;i+=2) {
			int a=arr[i];
			System.out.println(a);
		}
		//
		for(int i=0;i<arr.length;i++) {
			if(i%2!=0) {
				int a=arr[i];
				System.out.println(a);
			}
		}
	}

}
