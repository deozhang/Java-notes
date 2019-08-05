SpringMyBatis第一天
郭小培 TEL:19805160158

1.Spring简介:
	Spring是一个开源的轻量级的应用开发框架,其目的是用于简化企业应用程序的开发,降低侵入性
	
	Spring提供的IOC和AOP功能,可以将组件(类)之间的耦合度降至最低,即解耦,便于系统的升级和维护
	
	Spring的本质是管理软件中的对象,即创建对象和维护对象之间的关系

2.Spring容器
	在Spring中,任何组件都可以当成Bean处理,通过容器管理
	
	Spring容器有BeanFactory和ApplicationContext两种类型
	
	Spring容器的实例化
	ApplicationContext继承自BeanFactory接口,拥有更多的企业级开发方法(推荐)
	
	加载工程classpath下的配置文件实例化
	String xml = "配置文件路径";(物理路径)
	ApplicationContext ac = new ClassPathXmlApplicationContext(xml);

	Spring容器的使用
	首先在容器的配置文件spring.xml中添加Bean组件定义(容器中所有的组件都称为Bean组	件)
	<bean id="标识符" class="Bean组件的类型"></bean>
	然后在创建容器对象后,调用getBean方法获取Bean组件实例
	getBean("标识符");
	
	注明:Spring容器默认调用无参构造器来实例化
	
	