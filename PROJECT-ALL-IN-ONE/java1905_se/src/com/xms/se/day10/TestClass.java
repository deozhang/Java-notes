package com.xms.se.day10;

/**
 * java类加载机制
 * Class文件是由类加载器加载完成后，在jvm中形成一份描述Class结构元信息对象，
 * 通过该对象信息可以获取Class结构信息，如：构造方法属性，方法等。Java允许用户借用这个
 * Class对象来间接调用Class对象的功能。
 *
 * Java反射机制是在运行状态下，对任意一个类，都能够直接调用这个类的所有的属性和方法，
 * 对于这种动态获取信息以及动态调用对象方法属性的功能称之为反射机制。
 *
 * 反射就是把Java类中各个成分映射成一个个Java类的对象。
 */
public class TestClass {
    /**
     * 获取Class对象的方式
     * 1.Object--->getClass()
     * 2.任何数据类型(基本数据类型)，都有一个静态的class属性
     * 类名.class获取class对象
     * 3.通过Class类的静态方法：forName("String pathname")---最常用
     */
    public static void main(String[] args) {
        //第一种
        Student stu = new Student();
        Class clazz = stu.getClass();
        //获取类的名字
        System.out.println(clazz.getName());
        //第二种
        Class clazz1 = Student.class;
        System.out.println(clazz==clazz1);
        //第三种
        /**
         * forName(String path):
         * 注意：这个字符串表示的是类的真实路径，带包的路径
         * 语法：包名.类名
         * 有异常抛出
         */
        try {
            Class clazz2 = Class.forName("com.xms.se.day10.Student");
            System.out.println(clazz==clazz2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
