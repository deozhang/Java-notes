package com.xms.basic.day06.p;

import java.util.Arrays;
import java.util.Random;

/**
 * ��ϰ
 * @author Administrator
 *
 */
public class Demo01 {
	//1.��װһ���������"������һ��������"
	public static void method1() {
		System.out.println("������һ��������");
	}
	//2.��װһ���������ܹ��������ָ�����ȵ�int���͵�����[0-100]
	public static int[] method2(int length) {
		int[] arr=new int[length];
		Random rd=new Random();
		for(int i=0;i<arr.length;i++) {
			int a=rd.nextInt(101);
			arr[i]=a;
		}
		return arr;
	}
	//3.��װһ���������ܹ��ҳ�int�����������Сֵ
	public static int method3(int[] arr) {
		//���跨
		int min=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(min>arr[i]) {
				min=arr[i];
			}
		}
		return min;
	}
	//4.��װһ�����������Խ�ָ����int�������飬��������
	public static int[] method4(int[] arr) {
		//�����п��Ե��÷���
		/*
		 * 1.�Ƚ�ָ�����������������
		 * 2.Ȼ�󽫶�Ӧλ�õ���
		 */
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length/2;i++) {
			int temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
			
		}
		return arr;
		
	}
	
	//5.��װһ��������������ָ��int����������Ԫ�صĺ�
	public static int method5(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
		}
		return sum;
	}
	
//6.��װһ���������ж�����int���͵������Ƿ���ȣ�
//	�����ȣ��򷵻�ֵ���Ϊtrue����������򷵻�Ϊfalse
	public static boolean method6(int[] arr1,int[] arr2) {
		/*
		 * 1.�����ж����鳤���Ƿ����
		 * 				---�������
		 * 						�ж϶�Ӧλ���ϵ�Ԫ��ֵ���--true
		 * 						�ж϶�Ӧλ���ϵ�Ԫ��ֵ�����--false
		 * 				--���Ȳ���
		 * 						--�����ж�Ԫ��ֵ--false
		 */
		boolean flag=true;//����
		if(arr1.length==arr2.length) {//�������
			for(int i=0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					flag=false;
					break;
				}
				
			}
			return flag;
		}else {//���Ȳ���
			return !flag;
		}
	}
	//7.��װһ���������ܷ��������int����������֮���������ֵĺ�
	//�磺2,6
	//2+3+4+5+6==��
	public static int method7(int a,int b) {
		int sum=0;
		if(a>=b) {//a>=b
			for(int i=b;i<=a;i++) {
				sum=sum+i;
			}
		}else {//a<b
			for(int i=a;i<=b;i++) {
				sum=sum+i;
			}
		}
		return sum;
		
	}
	
	//8.��ָ����int���������뵽ָ����int���������е�ָ��λ��
	/*
	 * 1,2,3,4,5
	 * 
	 * 0  arr  1
	 * --->
	 * 1,0,2,3,4,5
	 * ������
	 * 1.��������  ��������1
	 * 2.��Դ�����е�Ԫ�أ���ֵ���µ� �����У���λ��ֵ
	 * 
	 * 
	 * 
	 * 123450-->12 2345
	 * 
	 */
	public static int[] method8(int num,int[] arr,int index) {
		//���鸴��
		int[] arrNew=Arrays.copyOf(arr, arr.length+1);
		for(int i=index;i<arr.length;i++) {
			arrNew[i+1]=arr[i];
		}
		arrNew[index]=num;
		return arrNew;
		
	}
	//9.��װһ����������������double�����ֺ�
	public static double method9(double a,double b) {
		return a+b;
	}
	
	
}


















































