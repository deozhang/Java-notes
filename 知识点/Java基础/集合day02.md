回顾：
String  创建对象   可以是字面量，还可以使用new关键
1.在使用字面量的时候会首先在堆内存中的常量池中寻找是否有之前创建过的该对象，如果有，则直接赋值，如果没有则重新创建
2.在使用new关键字创建对象的时候，在堆内存中强制开辟空间，同时在常量池中也会创建对象，但是两个对象的地址值不同（new String时会创建两个对象）

String是使用final定义，不可改变

==和equals的区别：

1.基本类型中==是比较变量的值，引用类型中==是比较两个引用变量的地址值
2.equals在比较两个对象的"内容"，如果内容相等，即使地址值不同，也可以认为是两个对象"相等"


字符串的使用频率较高，且频繁修改，在使用String修改字符串时，相当于重新创建对象
消耗内存资源，因此我们引入可变字符序列，来对字符串进行修改，可变字符序列不属于String

StringBuffer:线程安全，处理字符串的性能较慢
StringBuild:非线程，处理字符串的性能较快
append，insert，delete，replace，reverse，

Object：所有类的顶级父类
重写：
toString：
equals：


包装类：
自动拆箱<-->自动装箱
将基本类型转换成字符串的方法：String.valueOf（参数）

日期类：
Date：  
getTime（）获取1970到现在的毫秒数

SimplDateFormate：根据模型来进行字符串和Date之间的转换
formate（Date date）：将Date转换成指定格式的字符串
parse（String str）：将指定格式的字符串，转换成Date类

Date不方便对时间分量进行设置，因此引入日历类

日历类：获取对象的方法：getInstance()

get（）:
set（）:
add():

getTime():将日历对象转换成Date类
setTime(Date date):将将给定的日期类，转换成日历类
注意：设置时间分量时，周是从周日开始分别为：70123456
       月是从0开始从一月到十二月 分别：0123456789 10 11


集合：
Collection：父接口
	子接口：List，Set
	List接口下有两个实现类：ArrayList，LinkedList
	add,size,clear,isEmty,contains()使用equals比较,

今天：
集合的批量操作：

	





































