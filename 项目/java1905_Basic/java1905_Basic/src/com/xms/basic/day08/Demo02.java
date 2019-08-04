package com.xms.basic.day08;
/***
 * 默认父类是大于子类
 * 		
 * 	泛化：由多个子类提取公共的成员变量和方法，形成一个新的类的过程
 * 			整个过程称之为泛化（小类型--大类型）
 * 			向上造型：父类的引用指向子类的对象-----多态
 * 			语法：父类类型  引用变量名=new  子类类型();
 * 			注意：这个引用变量能调用什么，看这个变量的类型
 * 		
 * 特化：由一个公共的类型，衍生出多个子类的过程，这个过程称之
 * 			 为特化（大类型---小类型）
 * 			向下造型：强制类型转换
 * 			语法：子类类型  引用变量名=（子类类型）父类型的变量；
 * 			----instanceof关键字：判断对应的引用变量是否属于某一个类型
 * 					属于：true
 * 					不属于：false
 * 
 * 多态：提高一种公共的数据类型，方便方法封装时对数据类型的识别；
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
		
		//向上造型---多态(实现继承关系)
		Animal animalDog=new Dog();
		Animal animalCat=new Cat();
		animalDog.name="zs";
		//向下造型--强制类型转换
		/**
		 *  java.lang.ClassCastException:类转换异常
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
































