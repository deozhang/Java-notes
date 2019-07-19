package com.xms.entity;

public class Student {
    private int id;

    public Student(int id, String name, int age, int money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    private String name;
    private int age;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private int money;

}
