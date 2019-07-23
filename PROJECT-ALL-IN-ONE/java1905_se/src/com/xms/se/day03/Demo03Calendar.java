package com.xms.se.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * �����ࣺjava.util.Calendar
 * ��ΪDate�����ʱ����������㣬��������������
 * ������һ�������࣬���еķ������Զ�ʱ���������һһ����
 * 
 * ע�⣺��������
 * 			�·ݣ��·��Ǵ�0��ʼ		1~12�µ����ֱַ�Ϊ��0~11��
 * 			�ܣ�����Ϊһ�ܵĿ�ʼ    ����~���������ֱַ�Ϊ1-7��
 * 
 * 		
 * @author Administrator
 *
 */
public class Demo03Calendar {
	public static void method1() {
		//�������������
		Calendar cal=Calendar.getInstance();
		System.out.println(cal);
		
		/*
		 * get(int field):
		 * ��ȡ���������ʱ�������ֵ
		 * ����ֵΪ��Ӧʱ�����
		 */
		int year=cal.get(Calendar.YEAR);
		System.out.println("�꣺"+year);
		int month=cal.get(Calendar.MONTH);
		int day1=cal.get(Calendar.DAY_OF_MONTH);
		int day2=cal.get(Calendar.DATE);
		int hour1=cal.get(Calendar.HOUR);
		int hour2=cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("�£�"+month);
		System.out.println("�գ�"+day1);
		System.out.println("�գ�"+day2);
		System.out.println("ʮ��Сʱ��"+hour1);
		System.out.println("��ʮ��Сʱ��"+hour2);
		
		System.out.println("-----------------------------------");
		/*
		 * set(int field,int value):
		 * --1.field��ָ����ʱ�����
		 * --2.value:Ҫ������ֵ
		 * ��ָ����ʱ������趨ָ��ֵ
		 * 
		 */
		cal.set(Calendar.YEAR,2049);
		System.out.println(cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH,Calendar. OCTOBER);//���дӢ�ĳ����Է�����
		cal.set(Calendar.DATE,24);
		cal.set(Calendar.DAY_OF_MONTH, 26);
		cal.set(Calendar.HOUR,23);
		System.out.println(cal.get(Calendar.HOUR));
		/*
		 * һ���ĳһ��:DAY_OF_YEAR
		 * һ�ܵ�ĳһ��:DAY_OF_WEEK
		 * һ���µ�ĳһ�죺DAY_OF_MONTH    /DATE
		 */
		
	}
	
	public static void method2() {
		/*
		 * ����ϵͳ��ǰʱ�䣬��ʮ���Ľ����Ǽ��ţ�
		 */
		Calendar cal=Calendar.getInstance();
		int day=cal.get(Calendar.DAY_OF_YEAR)+25;
		cal.set(Calendar.DAY_OF_YEAR,day);
		System.out.println(cal.get(Calendar.DATE));
		
		int day1=cal.get(Calendar.DAY_OF_MONTH)+10;
		cal.set(Calendar.DAY_OF_MONTH,day1);
		System.out.println(cal.get(Calendar.DATE));
		//��day_of_month ��day_of_yearЧ����һ���� ���õ��ĳ������ڶ�����
		
		/*
		 * add(int field,int value):
		 * ֱ���ڶ�Ӧ��ʱ������ϼ���ֵ
		 * �ӣ�����    ��������
		 * һ������Ҫ����ʱ�䳬�������
		 */
		cal.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
	}
	
	public static void method3() {
		/*
		 * setTime(Date date):
		 * --��������Date�������ݣ�ת������������
		 * --void
		 * 
		 * getTime():
		 * --����ǰ����������ת������������
		 * --����ֵΪDate��������
		 * 
		 * ����ϵͳ��ǰʱ�䣬��ʮ���£�ʮ��󣬵��ܵ�������ʲô����
		 * ����ĸ�ʽ���¡�yyyy/MM/dd��
		 * 
		 */
		Calendar cal=Calendar.getInstance();
		//ʮ���º�
		cal.add(Calendar.MONTH, 10);
		//ʮ���
		cal.add(Calendar.DAY_OF_MONTH, 10);
		//����Ϊ����
		cal.set(Calendar.DAY_OF_WEEK, 4);
		Date date=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String str=sdf.format(date);
		System.out.println(str);
		
	}
	
	public static void method4() throws Throwable {
		/*
		 * ����һ��ʱ�䣬�����ʱ�������£�������ܵ�������ʲô����
		 * ���Ч������yyyy/MM/dd"
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("�밴��yyyy/MM/dd ��ʽ����һ�����ڣ�");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
//		String str="2049/03/06";
		Date date=sdf.parse(str);
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 3);
		cal.add(Calendar.DAY_OF_MONTH, 3);
		cal.set(Calendar.DAY_OF_WEEK,4);
		date=cal.getTime();
		str=sdf.format(date);
		System.out.println(str);
		
		sc.close();
	}
	
	public static void method5() throws Throwable {
		/**
		 * ������Ʒ�Ĵ������ڣ�
		 * 		Ч�������һ����Ʒ���������ڣ������ڣ�������ǰ�������
		 * 				�������������
		 * eg�����룺
		 * �������ڣ�2019/07/01
		 * �����ڣ�30
		 * �����ڣ�10
		 * 
		 * �����2019/07/21
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("�밴yyyy/MM/dd �ĸ�ʽ�����������ڣ�");
		String dates=sc.nextLine();
		System.out.println("�������뱣����ʱ��");
		int days=sc.nextInt();
//		String dates="2019/07/01";
//		int days=30;
		System.out.println("��������Ϊ��"+dates);
		System.out.println("������ʱ��Ϊ��"+days+"��");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal=Calendar.getInstance();
		Date date=sdf.parse(dates);
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days*2/3);
		date=cal.getTime();
//		long ms=date.getTime()+days*2/3*24*60*60*1000;
//		date=new Date(ms);
		dates=sdf.format(date);
		
		System.out.println("�������ʱ��Ϊ��"+dates);
		
		
	}
	public static void main(String args[]) throws Throwable {
//		method1();
//		method2();
//		method3();
//		method4();
		method5();
	}
	
}
