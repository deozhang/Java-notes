package com.xms.se;

import com.xms.se.day10.Student;

import java.util.Collections;

/**
 * jdk1.8�ض�
 * 1.Lambda���ʽ��jdk1.8��Ҫ�ĸ���
 * ---����ʽ�ӿ�
 *      һ���ӿ���ֻ��һ�����󷽷�(default��static����)
 *   Lambdaʡ�Թ���
 *   1.��������ʡ��
 *   2.ֻ��һ������ʱ��()����ʡ��
 *   3.ֻ��һ��return��䣬���Խ�return��{},;ʡ��(����һ��ʡ��)
 */
public class day11 {
    public static void main(String[] args) {
        Demo d = new DemoImple();
        d.add();
        //�����ڲ���
        Demo d1 = new Demo() {
            @Override
            public void add() {
                System.out.println("�����ڲ���");
            }
        };
        d1.add();
        //Lambda���ʽ--����ʽ�ӿ�
        Demo d2 = ()->{System.out.println("Lambda���ʽ");};
        d2.add();

//        Collections.sort(list,(o1,o2)->o1.age-o2.age);
//        for(Student student:list){
//            System.out.println(student);
//        }
        //list��������

    }
}
//�ӿ�
@FunctionalInterface
interface Demo{
    public void add();
    //Ĭ�Ϸ���
    default void add1(){
        System.out.println("add1");
    }
    //��̬����
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