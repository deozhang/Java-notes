package com.xms.se.day09;
/*
 * ���̲߳�����ȫ����
 * 
 * �������̲߳�����ȫ�����ԭ�򣺶���̲߳�������ͬһ������
 * ������������첽���ͬ��
 * �����ʩ������--ͬ����
 * ����һ�����Ƿ�ȫ���������ط����Ƿ����������Ϊ�̰߳�ȫ��������Ϊ���̰߳�ȫ
 * �������������ڲ�ͬ�ķ����ϣ���֤����߳��ڵ�����Щ����ʱ��ͬһʱ�̣�ֻ�ܵ���һ��������
 * ����������
 * ����ؼ��֣�synchronzed--���첽���ͬ��
 * 1.�ӷ����ϡ����׶ˣ�ִ��Ч�ʵ�
 * 2.������Ҫͬ���Ĵ������
 * 
 */
public class Demo05Thread {
	static Object obj=new Object();
public static void main(String[] args) {
	/*
	 * ȥ�̳����·�
	 * �̳�--��ͬ��Դ�����¼䣺��Ҫͬ���Ĵ���飩
	 * �˿�1--�߳�
	 * �˿�2--�߳�
	 * �˿�3--�߳�
	 */
	//�˿�1
	Thread t1=new Thread() {
		public void run() {
			buy("����");
		}
	};
	//�˿�2
	Thread t2=new Thread() {
		public void run() {
			buy("����");
		}
	};
	t1.start();
	t2.start();
}
//������Դ
public static void buy(String name) {
	try {
		System.out.println(name+"�����̳�");
		System.out.println(name+"��ѡ�·�");
		Thread.sleep(3000);
		/*
		 * ������������Ҫͬ���Ĵ����
		 * С��������Ҫ��һ������������ʱ�ö�����ʲô���͵Ķ�����
		 *һ��ʹ��jdk��װ��Object���Ͷ����������Բ��ô��������࣬��ʡ��Դ
		 */
		synchronized(obj) {
			 System.out.println(name+"�������¼�");
			 System.out.println(name+"�������·�");
			 Thread.sleep(2000);
		}
		System.out.println(name+"�����¼�");
		System.out.println(name+"����");
		Thread.sleep(1000);
		System.out.println(name+"���̳�");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
