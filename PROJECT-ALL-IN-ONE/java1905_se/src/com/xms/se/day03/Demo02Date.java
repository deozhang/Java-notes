package com.xms.se.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java�б�ʾʱ��ʹ��java.util.Date
 * ���þ���һ���̶���ʱ���ĺ�������ʾ
 * һ���ض���ʱ��
 * 
 * Java.util.Date���װ�����ڼ�ʱ�����Ϣ
 * ����Ĺ���ʱ��ļ��㷽���Ѿ��������������
 * �����Ѿ���д��toString����
 * 
 * @author Administrator
 *
 */
public class Demo02Date {
	public static void main(String args[]) throws Throwable {
		//�������������
		Date date=new Date();
		/*
		 * ϵͳ��ǰʱ�����1970/01/01 00:00:00:000
		 * �ĺ�����
		 * ʹ��Date����.getTime()��ȡ����ʱ��ԭ��ĺ�����  ����ֵΪlong����
		 * 
		 */
		System.out.println(date);
		long time=date.getTime();
		System.out.println(time);
		
		/**
		 * ʱ���ʽ����
		 * new SimpleDateFormat():
		 * --��ϵͳĬ�ϵ�ģʽ������ת�����ں��ı�
		 * new SimpleDateFormat(String str):
		 * --��ָ����ģʽ������ת�����ں��ı�   
		 * Date����չʾʱ�����ʽ�����Ѻã���������SimDateFormat������ʱ����õ�չʾ
		 * 
		 * 
		 * java.text.SimpleDateFormat�������Ի����йصķ�����
		 * ����ʽ�ͽ�������
		 * 
		 * 		��ʽ������--->�ı����ַ�����
		 * 			format(Date date):
		 * 			�������������ĳ�ָ�ʽת���ַ���
		 * 			����ֵΪ�ַ�������
		 * 
		 *	 	�������ı����ַ�����--->����
		 * 			parse(String str):
		 * 			��ĳ�ָ�ʽ���ַ���ת��������
		 * 			����ֵΪ���������
		 * 
		 * ע�⣺��Ҫָ��ģʽ��Ҫ��ת�����ݵ�ģʽһ����һ������� �ַ���ת���ڣ�
		 * 		�ַ���ת���ڣ��ַ����в�Ҫ��������
		 * 
		 * �������֣�java.text.ParseException:ת���쳣
		 * 
		 * 
		 */
		
		//չʾ��ʽ��2019/07/01 11:02:00
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//��������ת��Ϊָ����ʽ���ַ���
		String strTime=sdf.format(date);
		System.out.println(strTime);
		
		//��ĳ�ָ�ʽ���ַ���ת��Ϊ������
		//2018/08/08 12:12:12
		String str="2018/08/08 12:12:12";
		Date date1=sdf.parse(str);
		
		date.clone();
	}
	/**
	 * ����Լ������գ������ִӳ���������һ�����˼��죿
	 * ˼·��
	 * ��������ַ��� ת��Ϊ��������� 
	 */
	
	
}
