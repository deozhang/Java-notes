package com.xms.basic.day08;
/***
 * Ĭ�ϸ����Ǵ�������
 * 		
 * 	�������ɶ��������ȡ�����ĳ�Ա�����ͷ������γ�һ���µ���Ĺ���
 * 			�������̳�֮Ϊ������С����--�����ͣ�
 * 			�������ͣ����������ָ������Ķ���-----��̬
 * 			�﷨����������  ���ñ�����=new  ��������();
 * 			ע�⣺������ñ����ܵ���ʲô�����������������
 * 		
 * �ػ�����һ�����������ͣ��������������Ĺ��̣�������̳�֮
 * 			 Ϊ�ػ���������---С���ͣ�
 * 			�������ͣ�ǿ������ת��
 * 			�﷨����������  ���ñ�����=���������ͣ������͵ı�����
 * 			----instanceof�ؼ��֣��ж϶�Ӧ�����ñ����Ƿ�����ĳһ������
 * 					���ڣ�true
 * 					�����ڣ�false
 * 
 * ��̬�����һ�ֹ������������ͣ����㷽����װʱ���������͵�ʶ��
 * 			
 * 
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		Dog dog=new Dog();
		
		//��������---��̬(ʵ�ּ̳й�ϵ)
		Animal animalDog=new Dog();
		Animal animalCat=new Cat();
		animalDog.name="zs";
		//��������--ǿ������ת��
		/**
		 *  java.lang.ClassCastException:��ת���쳣
		 */
		if(animalDog instanceof Dog) {
			Dog dogOne=(Dog)animalDog;
			dogOne.noseColor=1;
			System.out.println("111");
		}
		if(animalDog instanceof Cat) {
			Cat catOne=(Cat)animalDog;
			catOne.color="black";
			System.out.println("222");
		}
		
		
		
//		Animal animalBird=new Bird();
		
	}

}
































