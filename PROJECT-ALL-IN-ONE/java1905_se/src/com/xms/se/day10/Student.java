package com.xms.se.day10;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", num='" + num + '\'' +
                '}';
    }

    public Student(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    //成员变量
    public String name;
    protected int age;
    int sex;
    private String num;
    //构造方法
    //无参数 public
    public Student(){
        System.out.println("无参数 pbulic");

    }
    //有参数--默认权限修饰符
    Student(String str){
        System.out.println("有参数--默认权限修饰符");
    }
    //有参数 public
   Student(char sex){
       System.out.println("有参数构造方法(char sex) --public");
   }
   //一个参数----受保护的
   protected Student(boolean n){
       System.out.println("一个参数的构造方法(boolean n)--protected");
   }
   //一个参数 私有的
    private Student(int age){
        System.out.println("一个参数(int age)--private");
    }


}
