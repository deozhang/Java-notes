package com.xms.basic.day09;
/**
 * ���ʿ���Ȩ�޷���
 * 		Ȩ�޹�ϵ�Ӵ󵽵�С������˳�����£�
 * 		public >protected >Ĭ�ϵģ���д��>private
 * 	
 * 		ʹ�÷�Χ���£�
 * 		public :�ڵ�ǰ�����¶�����ʹ�ã����࣬ͬ���࣬����ࣩ
 * 		protected:���࣬ͬ���࣬������ֻࣨ��ʹ�����ഴ�����󣬽��е��ã�
 * 		Ĭ�ϵģ����࣬ͬ������
 * 		private:����
 * 		
 * 
 * 		--public ��private--����
 * 		--���������ࣺpublic��Ĭ�ϵ�
 * 		--�ڲ��ࣺprotected��private�Ӷࣨ�ĸ�Ȩ�����ζ����������ڲ��ࣩ
 * @author Administrator
 *
 */
public class Demo02 {
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void methodDemo02() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
	

}

































