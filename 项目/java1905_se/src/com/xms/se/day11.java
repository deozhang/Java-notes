package com.xms.se;

import com.xms.se.day10.Student;

import java.util.Collections;

/**
 * jdk1.8特定
 * 1.Lambda表达式是jdk1.8重要的更新
 * ---函数式接口
 *      一个接口中只有一个抽象方法(default和static除外)
 *   Lambda省略规则
 *   1.参数可以省略
 *   2.只有一个参数时，()可以省略
 *   3.只有一条return语句，可以将return，{},;省略(必须一起省略)
 */
public class day11 {
    public static void main(String[] args) {
        Demo d = new DemoImple();
        d.add();
        //匿名内部类
        Demo d1 = new Demo() {
            @Override
            public void add() {
                System.out.println("匿名内部类");
            }
        };
        d1.add();
        //Lambda表达式--函数式接口
        Demo d2 = ()->{System.out.println("Lambda表达式");};
        d2.add();

//        Collections.sort(list,(o1,o2)->o1.age-o2.age);
//        for(Student student:list){
//            System.out.println(student);
//        }
        //list集合排序

    }
}
//接口
@FunctionalInterface
interface Demo{
    public void add();
    //默认方法
    default void add1(){
        System.out.println("add1");
    }
    //静态方法
    public static void add2(){
        System.out.println("add2");
    }
}
class DemoImple implements Demo{

    @Override
    public void add() {
        System.out.println("hello");
    }
}