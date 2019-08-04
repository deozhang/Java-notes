# Object类:   
java默认继承Object类,java类都继承了Object类的属性和方法     
toString() hashCode() equals()    

1.toString()    
默认返回值为String类型	类名全程@hashCode(0x)    

2.equals()  ==  比较引用地址是否相等     
	-->比较两个对象是否相等:"引用相等" "对象相等"  
	-->equals()在Object类中默认比较的是"引用相等"  
	(引用相等比较的是对象的地址,比较的是否是同一个对象;  
	对象相等的比较比的是对象的数据,比的是对象的内容)  
	建议覆盖:实现对象的比较  
	覆盖的规则:  
	1.自反性	2.对称性	3.传递性 4.一致性  
	

3.hashCode()	原则上是不同的对象hashCode()值不同  
1)hashCode()要和equals()一同覆盖(sun公司规定)  
a.当两个对象equals()比较为true,应该具有相同的hashCode()值  
b.当两个对象equals()比较为false,应该具有不同的hashCode()值  
c.hashCode()值要稳定,一个对象以后就不应该再发生变化  
2)默认的hashCode()是当前堆对象地址转换的一个整数,这个整数不  
是内存地址  
3)一般使用对象的OID值作为hashCode()值  
	OID值是对象的唯一编号,在项目中一般都是根据数据生成一个OID,  
	就是数据库的主键(唯一性约束)  
