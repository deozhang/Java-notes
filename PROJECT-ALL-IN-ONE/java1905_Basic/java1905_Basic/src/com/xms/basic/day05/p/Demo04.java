package com.xms.basic.day05.p;
/**
 * 2.��֪һ�����飬������Ԫ�غ͡�
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		int[] arr=new int[] {1,2,3,4,5,6,7};
		int sum=0;//��ʾ����Ԫ�صĺ�
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];//sum=sum+arr[i];
		}
		System.out.println("sum="+sum);
		
	}

}
