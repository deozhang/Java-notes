package com.xms.se.day09;
/**
 * 	����ϵͳ---����---�߳�
 * 
 * 	����:�����ǲ���ϵͳ�����е�һ������,�����а�����ĳЩ��ͬ��Դ���ڴ�����,
 * 		����ϵͳ���ý��̰����Ĺ������ֳ�һ��������ִ�е�Ԫ,
 *	�߳�:�����а�����һ�����߶������ִ�е�Ԫ��֮Ϊ�߳�,
 * 		�߳�ֻ�ܹ�����һ������,����ֻ�ܷ��ʸý�����ӵ�е���Դ
 * 
 * 	�̺߳ͽ��̵�����:
 * 	1.���̵Ļ��ֳ߶�Ҫ�����߳�,һ�����������ٰ���һ���߳�
 * 	2.���̳߶�Ҫ�����߳�,ʹ�ö��̵߳ĳ��򲢷��Ը�,���������ִ�й�����ӵ�ж������ڴ浥Ԫ,
 * 	������̹߳�����ڴ�,��߳��������Ч�ʺ���Դ������
 * 	3.���̵߳���������һ��Ӧ�ó�����,�ж��ִ�в��ֿ���ͬʱִ��,���ǲ���ϵͳ��û�н�����߳�
 * 	���ɶ�����Ӧ����ʵ�ֽ��̵ĵ��ȹ������Դ����.
 * 
 * 	���̵߳�ʹ�ó���:
 * 	1.ͨ����һ��Ӧ�ó�������Ҫ�ж������ͬʱ���е����,���ǿ��Խ�ÿ��������Ϊһ���߳�,
 * 	ʹ��������һͬ����
 * 	2.һ��Ӧ�ó����п���ʹ�õ�һ�߳����ĳ������,Ҳ����ʹ�ö���̴߳ﵽ������ɶ�Ӧ������
 * 
 * 	����ԭ��:
 * 	����߳�"ͬʱ"����,ֻ�����Ǹй��ϵ�����,��ʵ�϶���̲߳�������ʱ,�̵߳��Ƚ�ʱ�価���ܵ�
 * 	���Ȼ��ֳɶ��ʱ��Ƭ��(ʱ��Ƭ),ĳ���̻߳�ȡ��ʱ��Ƭʱ,��ᱻCPUִ��,����ȫ���̴߳���
 * 	�ȴ�״̬,�ȸ��߳�ʱ��Ƭ�����,�����������ȡʱ��Ƭ���̻߳ᱻCPUִ��.
 * 	����΢���ϸ����߳��Ǵ�������ͣͣ��״̬,���������������,���ǲ��Ǿ��������ϵ�"ͬʱ����".
 * 
 * 	ͬ��&&�첽
 * 	ͬ��:ָ���Ⱥ�˳���ִ�з�ʽ
 * 	�첽:����ִ�и��Ե�����,��������,����ͬʱ����.
 * 
 * 	��δ����߳�:
 * 	1.�̳�Thread��--Thread�����߳���
 * 		--������߳���һ��(��϶�ǿ)
 * 	2.ʵ��Runnable�ӿ�--Runnablle��һ������ӿ�,��һ����д����ķ���
 * 		--������߳��Ƿֿ���(��϶���)--����
 * 	3.�̳߳�
 * @author deo
 *	
 */
public class Demo01Thread {
	public static void method1() {
		/*
		 * 1.�̳�Thread��
		 */
		//ͬ��
//		for(int i=0;i<100;i++) {
//			System.out.println("000000");
//		}
//		for(int i=0;i<100;i++) {
//			System.out.println("111111");
//		}
		//�첽
		System.out.println("#########################################");
		//�����߳�
		Thread t1=new Thread1();
		Thread t2=new Thread2();
		/*
		 * 	�����߳�
		 * 	ע��:�����߳���start()����run()
		 */
		t1.start();
		t2.start();
	}
	public static void method2() {
		/*
		 * 	ʵ��Runnable�ӿ�
		 * 	--ʵ����ʵ��
		 * 	--�����ڲ���
		 */
		//ʵ����ʵ��
		//���������
		Runnable1 run1=new Runnable1();
		Runnable2 run2=new Runnable2();
		//�����߳�--����������ص���Ӧ���߳���
		Thread t1=new Thread(run1);
		Thread t2=new Thread(run2);
		/*
		 * start()���������̺߳�,������˵�߳����̾ͽ�������״̬
		 * 	���ǽ���Runnable(�ȴ�����ʱ��Ƭ),���ĳ���̷߳��䵽ʱ��Ƭ,����߳̿�ʼ����
		 */
		t1.start();
		t2.start();
		//�����ڲ���
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				//��������
				for(int i=0;i<1000;i++) {
					System.out.println("Hello Deo");
				}
			}
		};
		//�����߳�,��������
		Thread tt=new Thread(run);
		tt.start();
		Runnable run3=new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					System.out.println("�����ڲ���");
				}
			}
		};
		Thread t3=new Thread(run3);
		t3.start();
	}
	public static void main(String[] args) {
		method1();
//		method2();
	}
}

//1.�̳��߳���  --Thread
class Thread1 extends Thread{
	//����
	public void run() {
		//д��Ҫִ�е�����(����)
		for(int i=0;i<1000;i++) {
			System.out.println(6*6*6*6*6);
		}
	}
}
class Thread2 extends Thread{
	//����
	public void run() {
		//д��Ҫִ�е�����(����)
		for(int i=0;i<1000;i++) {
			System.out.println(8*8*8*8*8);
		}
	}
}

//2.ʵ��Runnable�ӿ�--ʵ�ֵ����֮Ϊ������
class Runnable1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(6*6*6*6*6);
		}
	}
}
class Runnable2 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(8*8*8*8*8);
		}
	}
}











