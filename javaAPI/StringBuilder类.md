# StringBuilder类
```java
package day01;
/*
 * 字符串不变对象的利弊：
 * 好处：最大程度的重用，节省空间
 * 弊端：对于频繁的修改字符串内容时会创建若干个对象
 */
public class Demo8 {
	public static void main(String[] args) {
		String str = "a";
//		for(int i = 0;i<10;i++) {
//			str+=str;
//		}
//		System.out.println(str);
		
		StringBuilder builder = new StringBuilder(str);
		for(int i=0;i<1000;i++) {
			builder.append("a");
		}
		System.out.println(builder);
/*
 * String = char[] + 操作
 * 数组是不变的
 * StringBuilder = char[] + 操作
 * 数组内容可变，如果长度不变，会利用变长算法来维护，自动扩容
 * 
 * StringBuilder用来修改字符串的类，是一个变长字符序列
 * StringBuilder JDK1.5 效率比较高 线程不安全（用的较多）
 * StringBuffer  JDK1.0 效率相对较低 线程安全
 * 
 * 方法：append、insert、delete、replace，返回值是StringBuilder对象本身
 * 的引用，如果我们的软件需要大量的字符串处理，建议使用StringBuilder
 * 
 */
		
		
	}
}
```

```java
package day01;

public class Demo9 {
	public static void main(String[] args) {
		/*
		 * 对字符串的修改有以下操作：
		 * 增：append()
		 * 删：delete()
		 * 改：replace()
		 * 插: insert()
		 */
		String str = "好好学习java";
		StringBuilder builder = new StringBuilder(str);
		/*
		 * StringBuilder append(String str)
		 * 向当前字符串末尾追加给定的字符串
		 * 
		 * 好好学习java，为了找个好工作
		 */
		builder.append("，为了找个好工作");
		System.out.println(builder);
		/*
		 * StringBuilder replace(int start,int end,String str)
		 * 将当前字符串中给定范围的字符串替换为给定的字符串
		 * 
		 * 好好学习java,为了改变世界
		 */
		builder.replace(11, builder.length(), "改变世界");
		System.out.println(builder);
		/*
		 * StringBuilder delete(int start,int end)
		 * 将当前字符串中给定的范围的字符串删除
		 * 
		 * ,为了改变世界
		 */
		builder.delete(0, 8);
		System.out.println(builder);
		/*
		 * StringBuilder insert(int offset,String str)
		 * 将给定的字符串插入到给定的位置中
		 * 
		 * 活着,就是为了改变世界
		 */
		builder.insert(0, "活着");
		System.out.println(builder);
	}
}

```

```java
package day01;

public class Demo10 {
	public static void main(String[] args) {
		/*
		 * reverse()
		 * 将当前字符串反转
		 */
		String str = "上海自来水来自海上";//回文
		StringBuilder b1 = new StringBuilder(str);
		StringBuilder b2 = new StringBuilder(str);
		b2.reverse();
		/*
		 * 注意:StringBuilder并没有实现equals()方法
		 * 所以,要比较字符串是否相同,要先转换为字符串后再进行比较
		 */
		if(b1.toString().equals(b2.toString())) {
			System.out.println("是回文");
		}else {
			System.out.println("不是回文");
		}
	}
}
```

```java
package day01;

public class demo11 {
	public static void main(String[] args) {
		System.out.println(testStringBuilder(10000));
		System.out.println(testString(10000));
	}
	//测试String的性能
	public static long testString(int n) {
		long start = System.currentTimeMillis();
		String str = "";
		for(int i=0;i<n;i++) {
			str+="abc";
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	//测试StringBuilder的性能
	public static long testStringBuilder(int n) {
		long start = System.currentTimeMillis();
		String str = "";
		StringBuilder builder = new StringBuilder(str);
		for(int i=0;i<n;i++) {
			builder.append("abc");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}

```
