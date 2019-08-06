# SpringMyBatis第一天  

郭小培 TEL:19805160158

## 1.Spring简介

Spring是一个开源的轻量级的应用开发框架,其目的是用于简化企业应用程序的开发,降低侵入性

Spring提供的```IOC```和```AOP```功能,可以将组件(类)之间的耦合度降至最低,即解耦,便于系统的升级和维护

Spring的本质是管理软件中的对象,即创建对象和维护对象之间的关系

## 2.Spring容器

在Spring中,任何组件都可以当成Bean处理,通过容器管理

Spring容器有```BeanFactory```和```ApplicationContext```两种类型

Spring容器的实例化
```ApplicationContext```继承自```BeanFactory```接口,拥有更多的企业级开发方法(推荐)

加载工程classpath下的配置文件实例化
String xml = "配置文件路径";(物理路径)

```java
ApplicationContext ac = new ClassPathXmlApplicationContext(xml);
```

Spring容器的使用
首先在容器的配置文件spring.xml中添加Bean组件定义(容器中所有的组件都称为Bean组件)

```xml
<bean id="标识符" class="Bean组件的类型"></bean>
```

然后在创建容器对象后,调用getBean方法获取Bean组件实例
getBean("标识符");

注明:Spring容器默认调用无参构造器来实例化

## 3.Bean作用域

Spring容器在实例化Bean时,可以创建以下作用域的Bean对象

```singleton```:在Spring容器中一个Bean定义对应一个实力对象,默认项
```prototype```:一个Bean定义对应多个实例对象

```request```:在一次HTTP请求中,一个Bean定义对应一个实例对象
```session```:在一个HTTP session中,一个Bean定义对应一个实例对象

Bean的作用域可以通过```<bean>```定义的scope属性指定

## 4.Bean的生命周期

指定初始化回调方法

```xml
<bean init-method=""/>
```

指定销毁回调方法,仅适用于singleton模式的Bean  

```xml
 <bean destroy-method=""/>
```

![123](./d.ico)