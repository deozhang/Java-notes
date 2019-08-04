# IO流

```
package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO流:输入输出流
 * 		输入和输出是相对于虚拟内存为主导
 * 		虚拟内存(程序)<--输入---物理内存(文件)
 * 		虚拟内存(程序)---输出-->物理内存(文件)
 *
 * 	InputStream:抽象类,所有字节输入流的父类
 * 	OutputStream:抽象类,所有字节输出流的父类
 *
 * 	节点流(低级流):可以从/向一个特定的位置读取/写出数据
 *  处理流(高级流):对一个已经存在的流进行封装,不会单独存在
 *  			是建立在低级流的基础之上;高级流可以嵌套使用
 *
 * 	第一组实现类:
 * 		文件字节输入输入流--低级流
 * 		FileInputStream:文件字节输入流
 * 			--read()...
 * 		FileOutputStream:文件字节输出流
 * 			--wirte(int n)...
 * @author deo
 *
 */
public class Demo03IO {
	public static void method1() throws Throwable {
		/*
		 * new FileOutputStream(String(File) name):
		 * new FileOutputStream(String(File) name,boolean append):
		 * name--文件路径(可以是字符串类型/File类型)
		 * append--true:可追加
		 * 		--false:不可追加
		 *
		 * 和RandomAccessFile不同:
		 * RandomAccessFile写入字节时,将源文件中的字节进行等量覆盖
		 * FileOutputStream则是将源文件中所有数据清除后,然后再重新写入
		 *
		 * 使用FileOutputStream想要在源文件中内容后面追加写入一些新的字节,则需要使用使用这个
		 * 构造方法,需要使用new FileOutputStream(String(File) name,boolean true):
		 */
		//文件字节输出流
		OutputStream fos=new FileOutputStream("33.txt",true);
		fos.write(20);//一次写出一个字节,低八位
		fos.write(30);//一次写出一个字节,低八位
		fos.write(40);//一次写出一个字节,低八位
		fos.write("中国".getBytes("gbk"));
		fos.close();//关闭流,释放空间资源
		System.out.println("输出成功");
	}
	public static void method2() throws Throwable {
		/*
		 * 文件复制
		 * 1.一个字节一个字节
		 * 2.缓冲字节数组
		 */
		//输入流
		InputStream fis=new FileInputStream("src.txt");
		//输出流
		OutputStream fos=new FileOutputStream("fos.txt");
		//创建字节数组
		byte[] buf=new byte[1024*100];
		//循环读取和写入
		int index=-1;
		while((index=fis.read())!=-1) {
			fos.write(buf,0,index);
		}
		//关闭流
		fis.close();
		fos.close();
		System.out.println("复制成功");
	}

	public static void main(String[] args) throws Throwable {
		//输出流
//		method1();
		method2();
	}
}
```

```
package com.xms.se.day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 第二组实现流:
 * 		缓冲字节输入输出流---高级流
 * 		BufferedInputStream:缓冲字节输入流
 * 			--read
 * 		BufferedOutputStream:缓冲字节输出流
 * 			--write
 *
 * 这两个流内部各自维护着一个缓冲区(自带缓冲区)
 *
 * 关闭流时:
 * 只需要将高级流关闭即可,低级流会随着高级流的关闭而关闭
 *
 * 自带缓冲区和外加缓冲区的区别:
 * 	在读写相同的字节长度文件的情况下,外加缓冲字节数组要比自带缓冲字节数组
 * 的读写效率要高,原因是自带缓冲区在读写时多了一个换缓冲区的操作
 * --多一个"换车"环节
 * @author deo
 *
 */
public class Demo04IO {
	public static void method1() throws Throwable {
		//低级流
		OutputStream fos=new FileOutputStream("44.txt");
		//缓冲字节输出流--高级流
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//向目标文件中写出数据
//		fos.write(20);
		/*
		 * 自带缓冲区的输出流,只有将缓冲区存满,才会将缓冲区中数据
		 * 一次性写出,如果缓冲区没有存满,则会将写出的数据存入缓冲区中.
		 *
		 * 如果想将未满的缓冲区数据写出:
		 * 1.flush()--强制将未满的缓冲区数据写出(降低读写效率)
		 * 2.关闭流
		 */
		bos.write(20);
//		bos.flush();
		bos.close();
		System.out.println("写出完毕");
	}
	public static void method2() throws Throwable{
		//输入
		FileInputStream fis=new FileInputStream("src.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		//输出
		//复制
		//关闭流
	}
	public static void main(String[] args) throws Throwable {
		method1();
	}
}
```


```
package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 第三组实现流:
 * 		对象流--高级流
 * 		ObjectInputStream:对象输入流
 * 			--readObject()
 * 		ObjectOutputStream:对象输出流
 * 			--writeObject()
 *
 * 1.将特定结构的数据转成一组字节的过程--序列化
 * 2.将数据写入到物理内存中保存的过程--持久化
 * 3.将字节转成特定的结构数据的过程--反序列化
 *
 * 序列化和反序列化作用:
 * 1.数据的传输
 * 2.数据的保存
 *
 * {@link Serializable}可序列化的接口
 * 如果一个类的对象,想要进行序列化,该类需要实现可序列化的接口,
 * 此时该类的对象,才有资格进行序列化
 * java.io.NotSerializableException:未实现序列化的接口
 *
 * transient:修饰成员变量,在序列化时忽略该成员变量的值
 * (没有将该数据保存到目标文件中 )
 * @author deo
 *
 */
public class Demo05Object {
	public static void method1() throws Throwable {
		/*
		 * 序列化
		 */
		//低级流
		FileOutputStream fos=new FileOutputStream("stu.txt");
		//高级流--对象流
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Student s=new Student("zd",18);
		/*
		 * writeObject(Object obj):
		 * 属于ObjectOutputStream类中的方法
		 * 该方法可以将给定的嗯对象转成一组字节写入到目标文件中
		 */
		oos.writeObject(s);
		oos.close();
		System.out.println("序列化完成");
	}
	public static void method2() throws Throwable {
		/*
		 * 反序列化
		 */
		//低级流
		FileInputStream fis=new FileInputStream("stu.txt");
		//高级流--对象流
		ObjectInputStream ois=new ObjectInputStream(fis);
		/*
		 * readObject():
		 * 属于ObjectInputStream类中的方法
		 * 该方法可以读取一个对象,返回值为Object类型的数据
		 *
		 * 需要强制类型转换,才能获取对应对象的数据
		 */
		Object obj=ois.readObject();
		if(obj instanceof Student) {
			Student s=(Student)obj;
			System.out.println(s.name);
			System.out.println(s.age);
		}
		System.out.println(obj);
		ois.close();
		System.out.println("反序列化完成");
	}


	public static void main(String[] args) throws Throwable {
//		method1();
		method2();
	}
}
//学生类
class Student implements Serializable{
	/**
	 * 版本号:IDE自动生成
	 * 防止在序列化后,反序列化前,增加类的内容,出现异常,使用IDE自动生成
	 * 序列化的版本号
	 *
	 * 需要在序列化之前加入版本号
	 */
	private static final long serialVersionUID = 1L;
	String name;
	transient int age;//在序列化时忽略该成员变量的值
	char sex;//新增
	public Student() {

	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
```

```
package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 字符流(转换流):将字节--->字符	高级流
 * 		两个抽象类
 * 			Reader:字符输入的父类
 * 			Writer:字符输出的父类
 * 		字符流和字节流:Reader/Writer全都是字符流
 * 		字符流:是以字符为操作单位读写数据
 * 		字符流只能用于读写文本文件(不能读写视频,音频,图片)
 * 		如果想要读写其他数据,则使用字节流
 *
 * 		实现类:
 * 			{@link InputStreamReader}字符输入流
 * 				new InputStreamReader(InputStream is)
 * 				new InputStreamReader(InputStream is,String charSet)
 * 			{@link OutputStreamWriter}字符输出流
 * 				OutputStreamWriter(OutStream os)
 * 				OutputStreamWriter(OutStream os,String charSet)
 *
 *
 * @author deo
 *
 */
public class Demo06WR {
	public static void method1() throws Throwable {
		/*
		 * 字符输出流
		 */
		//低级流
		OutputStream os=new FileOutputStream("55.txt");
		//字符流--高级流	以系统默认的字符集编码
		OutputStreamWriter osw=new OutputStreamWriter(os);
		osw.write("中国人");
		osw.close();
		System.out.println("字符输出完毕");
	}
	public static void method2() throws Throwable {
		/*
		 * 输入流
		 */
		//低级流
		InputStream fis=new FileInputStream("55.txt");
		//高级流--字符流
		InputStreamReader isr=new InputStreamReader(fis);
		/*
		 * read()
		 * 一次读取一个字符,根据字符集编码不同
		 * 对应读取的字节数
		 */

		int i=isr.read();
		System.out.println((char)i);
		isr.close();
		System.out.println("读取完毕");
	}
  public static void method3() throws Throwable {
  /*
   * 利用字符流复制文本文件
   */
  //输入流
  InputStream fis=new FileInputStream("src.txt");//字节流
  InputStreamReader isr=new InputStreamReader(fis,"utf-8");//字符流
  //输出流
  OutputStream fos=new FileOutputStream("isr.txt");
  OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
  //循环读取和写出
  int index=-1;
  while((isr.read())!=-1){
    osw.write(index);
  }
  //关流
  isr.close();
  osw.close();
  System.out.println("字符流复制完毕");
}


	public static void main(String[] args) throws Throwable {
		method1();
		method2();
		method3();
	}
}
```
