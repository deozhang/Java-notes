package com.xms.basic.day05.p;

import java.util.Arrays;

/**
 * 
7.��֪һ������arr��������Ԫ�ش浽arrj�����У�ż��Ԫ�ش浽arro�����С�
  ˼·��
  		1.�����arr����������Ԫ�صĸ���/ż��Ԫ�ظ���
  		2.������������/ż������
  		3.��arr�����У�����Ԫ�ط�������������
  								 ż��Ԫ�ط���ż��������
  								 ע��:
  								 		����Ԫ��/ż�� Ԫ�������±궼�Ǵ�0��ʼ

 * @author Administrator
 *
 */
public class Demo09 {
	public static void main(String[] args) {
		int[] arr=new int[] {1,2,3,4,5,6,7,8,9};
		//1.����ż����������Ԫ�صĸ���
		int n=0;//������
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {//ż��
				n++;
			}
		}
		//2.�����Ӧ������
		int[] arrj=new int[arr.length-n];
		int[] arro=new int[n];
		//3.����Ӧ��Ԫ�ط����Ӧ��������
		//ע�⣺�±�
		int o=0;//ż���±�
		int j=0;//�����±�
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {//ż��Ԫ��
				arro[o++]=arr[i];
			}else {///����Ԫ��
				arrj[j++]=arr[i];
			}
			
		}
		System.out.println(Arrays.toString(arro));
		System.out.println(Arrays.toString(arrj));
	}
	

}




















































