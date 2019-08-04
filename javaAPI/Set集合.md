# Set集合:无序集/不重复集  
Set集合中不会出现两个equals比较为true的元素  
```java
package day06;

import java.util.HashSet;
import java.util.Set;

//Set集合:无序/不重复
public class SetDemo1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("two");
		set.add("one");
		set.add("three");
		/*
		 * 元素存放顺序与元素在集合内部保存的位置不一致
		 * 只要元素不变,无论哪个元素先放入集合,集合内部存放元素的顺序不变
		 *
		 */
		System.out.println(set.size());
		System.out.println(set);
		//set集合不能存入重复的元素
		set.add("one");
		System.out.println(set);
	}
}

```
```java
package day06;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//遍历Set集合
public class SetDemo2 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		//迭代器的方式
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//新循环的方式
		for(String str:set) {
			System.out.println(str);
		}
	}
}

```
## Set集合的实现类:  
TreeSet:使用二叉树实现  
HashSet:使用散列算法实现    

对于HashSet而言:它存取元素时依赖元素的hashCode()方法  
hashCode()方法是Object定义的方法,所有的类都具备该方法  
通常我们重写一个类的equals()方法是就要连同重写hashCode()  
```java
package day06;
//测试元素的equals()与hashCode()的重写规则
public class Element {
	private int x;
	public Element(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (x != other.x)
			return false;
		return true;
	}
}
```
```java
package day06;

import java.util.HashSet;
import java.util.Set;

public class SetElementDemo1 {
	public static void main(String[] args) {
		Set<Element> set = new HashSet<Element>();
		Element e1 = new Element(1);
		Element e2 = new Element(1);
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode()==e2.hashCode());

		set.add(e1);
		set.add(e2);
		System.out.println(set.size());
	}
}

```
## 重写hashCode()的注意事项:  
1.hashCode()在被多次调用时应返回一个稳定的值,除非参与的equals()比较的属性值发生改变  
2.当两个对象equals()方法比较为true时,两个对象的hashCode()方法返回值应当相同  
3.当两个对象equals()方法比较结果为false时,不要求hashCode()方法返回的结果不同,  
但是不相等的两个对象使用不同的hashCode()会提高散列表的性能  
