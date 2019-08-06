一.Hibernate简介
	1.什么是Hibernate
		Hibernate的概念
			Hibernate是数据访问层的框架,对JDBC进行了封装,是针对数据访问提出的面向			  对象的解决方案

		Hibernate的作用
			使用Hibernate可以直接访问对象,Hibernate自动将此访问转换成SQL执行,从			 而达到简介访问数据库的目的,简化了数据访问层的代码
	 
	2.为什么要用Hibernate
		Hibernate与SQL对比
			使用JDBC的缺点:
			--需要编写大量的SQL语句
			--需要大量的?参数赋值
			--需要将ResultSet结果集转换成实体对象
			--SQL中包含特有函数,无法移植
			使用Hibernate可以解决上述问题:
			--自动生成SQL
			--自动给?参数赋值
			--自动将ResultSet结果集转换成实体对象
			--采用一致的方法对数据库进行操作,移植性好
		
		Hibernate与MyBatis对比
		共性:
		--对JDBC进行了封装
		--采用ORM思想解决了Entity与数据库的映射关系
			MyBatis
			--MyBatis采用SQL与Entity映射,对JDBC封装程度较轻
			--MyBatis自己写SQL,更具有灵活性
			Hibernate
			--Hibernate采用数据库与Entity映射,对JDBC封装程度较重
			--Hibernate自动生成SQL,对于基本的操作,开发效率较高

二.使用Hibernate
	1.Hibernate框架的设计原理
		设计原理
			Hibernate采用ORM思想对JDBC进行封装,Hibernate框架是ORM思想的一种实				现,解决对象和数据库映射问题
			
			Hibernate提供一系列API,允许我们直接访问实体对象,然后根据ORM映射关系,				转换成SQL去执行,从而达到访问数据库的目的
			
			ORM思想
			ORM:Object Relation Mapping,即对象关系映射,指的是Java对象和关系数			 据库之间的映射,ORM思想就是将对象和数据库进行相互转换的思想,不同的框架/技			术实现ORM的手段不同,但更多的是采用配置+反射的方法实现ORM
			
	2.Hibernate框架体系结构
		配置文件(注:cfg是config的缩写)
		Hibernate的主配置文件是一个XML文件,通常命名为hibernate.cfg.xml
		此文件中可以配置数据库连接参数,Hibernate框架参数,以及映射关系文件
		
		实体类
		实体类是数据库表对应的Java类型,	它是用于封装数据库记录的的对象类型
		
		映射关系文件
		映射关系文件制定实体类和数据表的对应关系,即类中的属性和表中字段之间的对象关系
		Hibernate使用XML文件来描述映射关系,文件通常命名为"实体类.hbm.xml",存放于		实体类相同的路径下
		36:26
	3.如何使用Hibernate
	4.Hibernate映射类型


​		
​		
​		