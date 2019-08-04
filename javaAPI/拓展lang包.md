# 利用[commons-lang3-3.1.jar](http://www.java2s.com/Code/Jar/c/Downloadcommonslang331jar.htm)拓展lang包
## 添加步骤：
* 下载lang包
* 在项目下创建Floder,命名为lib
* 右键项目名->BulidPath->Configure BulidPath->Libraries->Add JARs添加lang包
> 如果右键项目名时没有BulidPath：在eclipse导航栏中 Window->Show View->Package Explorer

```java
package day01;
import org.apache.commons.lang3.StringUtils;
/*
 * commons-lang
 * 该包是由Apachce组织提供的用于拓展java中lang包的类的一些方法
 */
public class Demo7 {
	public static void main(String[] args) {
		/*
		 * String repeat(String str,int repeat)
		 * 将给定的字符串重复次数返回
		 */
		String repeat = StringUtils.repeat("abc", 5);
		System.out.println(repeat);
		
		String str = "123,456,789";
		String[] array = str.split(",");
		/*
		 * join()
		 * 将给定的数组中每一项按照给定的字符串连接在一起
		 * 这个方法相当于split()反操作
		 */
		String join = StringUtils.join(array,".");
		System.out.println(join);
		
		/*
		 * String leftPad(String str,int size,char chs)
		 * 将给定的字符串str左侧添加若干个给定的字符chs,以使
		 * 当前字符串达到给定的长度size
		 */
		String str1 = "1234";
		String leftPad = StringUtils.leftPad(str1, 10,'*');
		System.out.println(leftPad);
		
		/*
		 * String rightPad(String str,int size,char chs)
		 * 与leftPad()相同，只是在右侧补充字符
		 */
		String rightPad = StringUtils.rightPad(str1, 10,'#');
		System.out.println(rightPad);
	}
}

```
