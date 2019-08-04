# Map
> 是一个多行两列的表格,每一行存储一项  
一项包含两个部分:key-value(键值对)  
其常见的实现类:HashMap 使用散列算法实现的Map  

散列表:  
* 容量:散列表中散列数组的大小  
* 散列运算:key-->散列值的算法
* 散列桶:散列值相同的元素的"线性集合"
* 加载因子:散列数组的加载率,一般小于75%性能就比较理想(元素数量/散列数组的大小)
* 散列查找:根据key计算散列值,根据散列值的下标找value
* 散列表中的key不同,value可以相同
```java
package day06;

import java.util.HashSet;
import java.util.Set;
/*
 * 当一个元素存入HashSet集合后,尽量不要使用该元素的HashCode()
 * 再使用hashCode()返回值会发生变化,降低散列表的性能
 */
public class SetElementDemo2 {
	public static void main(String[] args) {
		Set<Element> set = new HashSet<Element>();
		Element e = new Element(1);
		set.add(e);
		e.setX(2);
		set.add(e);
		e.setX(3);
		set.add(e);
		System.out.println(set.size());
		System.out.println(set);

		set.remove(e);
		System.out.println(set.size());
		System.out.println(set);

		e.setX(2);
		set.remove(e);
		System.out.println(set.size());
		System.out.println(set);
	}
}

```
HashMap性能调优:  
这个比值超过0.75是,散列数组将扩容,存在原来数组中的数据要重新进行散列运算之后存入新数组,  
并不是简单的将原数组中的数据复制到新数组中,这个过程称为rehash(重新散列),那么扩容数组,  
rehash会带来一定的性能开销  

HashMap:以键值对存储对象,关键字key是唯一的,不重复的  
1. key可以是任意对象,value也可以是任意对象  
2. key-value成对放置在集合中
3. 重复的key算一个,重复添加时时替换操作
4. 根据key的散列值计算散列表,元素按照散列值排序
5. HashMap的默认容量是16,默认的加载因子是0.75
6. HashMap可以根据key检索查找value的值
7. HashMap可以在构造器中指定参数:初始容量和加载因子

Map的常用方法:
V put(K k,V v)
将一组key-value对存入Map,因为Map要求key不允许重复,所以若使用相同的key存入不同的元素时,是替换value操作,put的返回值是被替换的value  

V get(Object k)  
根据给定的key获取
```java
package day06;

import java.util.HashMap;
import java.util.Map;
//尽管Map是用来保存数据的,但是Map不是集合
public class HashMapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map =
				new HashMap<String,Integer>();
		/*
		 * 因为第一次存放元素,返回值为null
		 * 那么当我们用int接受返回值时,就触发了自动拆装箱的特点
		 * JVM试图使用返回值的Integer的intValue(),将对象转换为基本类型,
		 * 但是返回值时null,所以引发了空指针异常
		 */
//		int num = map.put("one", 1);
//		System.out.println(num);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		System.out.println(map.size());
		System.out.println(map);

		int num = map.put("one", 100);
		System.out.println(num);//1
		System.out.println(map);

		int v = map.get("one");
		System.out.println(v);//100
		/*
		 * 使用Map时要注意:
		 * 若我们value的类型是8个基本类型的包装类时,
		 * 接收返回值要真对null做处理,避免因为自动拆装箱二引发的空指针异常
		 */
		Integer in = map.get("five");
		System.out.println(in);

		/*
		 * boolean containsKey(Object k)
		 * 查看给定的key是否包含在Map中
		 */
		System.out.println(map.containsKey("five"));
		/*
		 * boolean containsValue(Object v)
		 * 查看给定的value是否包含在Map中
		 */
		System.out.println(map.containsValue(100));
	}
}

```
HashSet就是使用HashMap实现的,它利用了HashMap对于key不允许重复的特点以及散列算法的优点  
```java
package day06;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo2 {
	public static void main(String[] args) {
		//统计当前字符串中每一组数字出现的次数
		String line = "123,456,123,789,345,234,345,678,234";
		String[] array = line.split(",");
		Map<String,Integer> map =
				new HashMap<String,Integer>();
		for(String num : array) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
//				int value = map.get(num);
//				value = value + 1;
//				map.put(num, value);
				map.put(num, map.get(num)+1);
			}
		}
		System.out.println(map);
	}
}

```
遍历Map的三种方式:  
1. 遍历所有的key  
2. 遍历每一组键值对  
3. 遍历所有的value(在map中很少使用)  
```java
package day06;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
//遍历Map
public class HashMapDemo3 {
	public static void main(String[] args) {
		Map<Integer,String> map =
				new HashMap<Integer,String>();
		map.put(1,"one");
		map.put(2,"two");
		map.put(3,"three");
		map.put(4,"four");
		/*
		 * 遍历所有的key
		 * Set keySet()
		 */
		Set<Integer> keySet = map.keySet();
		for(int key:keySet) {
			System.out.println(key);
		}
		/*
		 * 遍历所有的键值对
		 * 每一组键值对使用一个Entry类的实例来描述
		 *
		 * Set entrySet()
		 * Entry:要求定义两个泛型,来说明其描述的键值对中key与value的类型,
		 * 这里我们通常使用Map的泛型
		 */
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		for(Entry<Integer,String> entry : entrySet) {
			/*
			 * getKey()和getValue()方法分别用于获取一组键值对的
			 * key和value
			 */
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
		}
		/*
		 * 遍历所有的value
		 * Collection values()
		 */
		Collection<String> values = map.values();
		for(String value : values) {
			System.out.println(value);
		}
	}
}

```
```java
package day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//HashMap的使用场景
public class HashMapDemo4 {
	public static void main(String[] args) {
		Map<String, List<Person>> map =
				new HashMap<String,List<Person>>();
		//所有的家人
		List<Person> list1 = new ArrayList<Person>();
		list1.add(new Person("爸爸"));
		list1.add(new Person("妈妈"));
		list1.add(new Person("爷爷"));
		list1.add(new Person("奶奶"));
		//所有的女朋友
		List<Person> list2 = new ArrayList<Person>();
		list2.add(new Person("林志玲"));
		list2.add(new Person("刘亦菲"));
		list2.add(new Person("苍井null"));
		list2.add(new Person("贾玲"));

		map.put("家人", list1);
		map.put("女朋友", list2);

		System.out.println(map);

		//获取所有的家人
		List<Person> flist = map.get("家人");
		for(Person p : flist) {
			System.out.println(p);
		}
	}
}
class Person{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public String toString() {
		return "联系人:" + name;
	}

}

```
HashMap  新 速度快 非线程安全 不检查锁 较常用  
hashTable  旧(jdk1.2之前)

重点掌握:ArrayList\LinkedList\HashSet\HashMap\
