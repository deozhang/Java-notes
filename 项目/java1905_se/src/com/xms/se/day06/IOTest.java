package com.xms.se.day06;

import java.io.IOException;
import java.io.RandomAccessFile;

public class IOTest {
    public static void method() throws IOException{
        RandomAccessFile w = new RandomAccessFile("66","rw");
        w.write(111);
        w.write(222);
        w.write(333);
        w.write(444);
        w.close();
        System.out.println("写入完毕");
    }
    public static void method1() throws IOException{
        RandomAccessFile r = new RandomAccessFile("66","r");
        int i = r.read();
        int i1 = r.read();
        int i2 = r.read();
        int i3 = r.read();
        int i4 = r.read();
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        r.close();
        System.out.println("读取完毕");
    }

    public static void main(String[] args) throws IOException {
        method1();
    }
}
