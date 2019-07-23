package com.xms.se.day10;

import java.lang.reflect.Constructor;

/**
 * 通过Class对象可以获取某个类中构造方法，成员变量，方法，并调用
 *
 * 1.获取构造方法
 *    --1.批量获取
 *    getConstructors:获取所有的公共的构造方法
 *    getDeclaredConstructors:获取所有的构造方法
 *    --单个获取
 *    geetConstructor获取某个公共的构造方法
 *    getDeclaredConstructor获取某个构造方法
 *
 */
public class TestConstructor {
    public static void main(String[] args) {
        Class stuClass = null;
        try {
            stuClass=Class.forName("com.xms.se.day10.Student");
            //获取所有的构造方法
            System.out.println("获取所有的公共的构造方法");
            Constructor[] arrCon = stuClass.getConstructors();
            for (Constructor constructor :
                    arrCon) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //使用构造方法创建对象
        try {
            Constructor con = stuClass.getConstructor();
            Object obj = con.newInstance();
            Student s = (Student)obj;
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取某一个构造方法
        try {
            Constructor con = stuClass.getDeclaredConstructor(int.class);
            //忽略权限修饰符
            con.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
