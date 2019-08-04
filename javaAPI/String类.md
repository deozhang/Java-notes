String类:char[]+操作  
1.char[]本身就是一串字符,java可以作为字符串  
2.concat()底层使用的数组的复制     拼接  

# String类:  
a.char数组只有数据,没有操作  
b.一串字符就是字符串:String\char[]\StringBuilder  
c.字符串的字面量都是String类型的  
d.字符串的常亮: static final  
e.String内部就是一个char数组  

String有一个原则,对象内容不变,String对象永远不变,这样的规定  
是字符串使用起来跟基本类型一样.  
String字面量相同的时候,会替换为同一个String对象的引用,常量池会  
优化为同一个字符串,String的比较使用equals()  

## String的常用方法:  
a.字符串覆盖了Object类的equals()\hashCode()\toString()  
b.String字符串中的所有字符都有下标,下标从0开始,到length()-1结束  
c.字符串里的方法使字符串有了变化就要返回一个新的String对象  
不变化就返回原字符串  
* charAt():获取指定下标的字符  
* indexOf():获取字符的下标  
* lastIndexOf():查看给定字符串在当前字符串中最后一次出现的位置  
* toUpperCase():将当前字符串中所有的小写字母转换为大写  
* toLowerCase():将当前字符串中的所有大写字符转换为小写  
* trim():去除当前字符串中两遍的空白  
* startsWith():判断当前字符串是否以给定的字符串开始  
* endsWith():判断当前字符串是否以给定的字符串结尾  
* length():获取当前字符串的长度(字符数量)  
* equals():比较两个字符串的内容是否相等  
* equalsIgnoreCase():可以忽略英文大小写来比较字符串的内容是否一致  
* substring():截取当前字符串,从给定的位置开始截止到给定位置  
* toCharArray():将给定的字符串转换为字符数组  
* getBytes():根据给定的字符集将当前字符串转换为对应的字节序列(字节码)并返回  
```java
	public static void main(String[] args) throws UnsupportedEncodingException {
		//从字符串转换为字节序列的过程称之为编码
		String str = "我爱java";
		byte[] gbk = str.getBytes("GBK");
		System.out.println(gbk.length);//一个中文占两个字节
		System.out.println(Arrays.toString(gbk));
		byte[] utf = str.getBytes("utf-8");
		System.out.println(utf.length);//一个中文占三个字节
		System.out.println(Arrays.toString(utf));
		//String的构造方法
		//String(byte[] data,String charsetNama)
		//从字节序列转换为字符串的过程称之为解码
		String utfStr = new String(utf,"utf-8");
		System.out.println(utfStr);
	}
```
