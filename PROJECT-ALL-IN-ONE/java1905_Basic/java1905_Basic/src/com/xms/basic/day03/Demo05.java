package com.xms.basic.day03;
/**
 * ����ķ�֧�ṹ:
 * 		switch-case:����switch�е�ֵ�������case��ֵ���е�ֵ�Ƚϣ�
 * 		���������ȣ���Ӹ���ڽ��룬ִ�и�case����е��߼����롣
 * 		�﷨��
 * 			switch(����/�ַ���/�ַ���){
 * 					case ����ֵ1��
 * 							�߼����1��
 * 					case ����ֵ2��
 * 							�߼����2��
 * 					case ����ֵ3��
 * 							�߼����3��
 * 					......
 * 					......
 * 					
 * 					default:
 * 							Ĭ����䣻
 * 
 * 
 * 			}
 * 		ִ�����̣�����switch�д�case��ڴ��ϵ�������ֵ�жϣ����switch�е�
 * 						ֵ��ĳһ��case�����ȣ���Ӹ���ڽ���ִ����һֱ������switch-case
 * 						ִ����ϣ����û���ҵ���Ӧ����ڣ���ִ��Ĭ�ϵ�default���
 * 	
 * 		switch-case:���Դ���break�ؼ���ʹ�ã���������switch-case�ṹ
 * 		switch-case����ȱ��:
 * 			1.�ŵ㣺�ṹ�򵥣�������ʹ�÷���
 * 			2.ȱ�㣺�������������ƣ�ֻ������ֵ�ж�
 * 
 * 		if��switch-case������
 * 			1.���߶��Ƿ�֧�ṹ�������ж�����������ִ��ĳЩ���
 * 			2.switch-case�����ж�����ʱ�����������͵����ƣ���ֻ��
 * 										����ֵ�жϣ�������ֵ���ж�
 * 			3.if�������ж��κ����͵����ݣ��ȿ�������ֵ�жϣ�Ҳ������
 * 										ֵ���ж�
 * 				----���е�switch--case������ʹ��if����д������switch-case
 * 					  ֻ�ܸ�дif����еĵ�ֵ�ж�
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
//		int key=5;
//		char key='b';
		String key="d";
		switch(key) {
			case "a":
				System.out.println("1");
				break;//ǿ�Ʋ���--��switch-case���
			case "b":
				System.out.println("2");
				break;
			case "c":
				System.out.println("3");
				break;
			default :
				System.out.println("Ĭ�����");
				break;
		}
		
		
	} 

}












































