## 一、JDBC代码优化

* *.properties file in src  

* utf8  

* annotations



## 二、语句对象

> `Statement`: 主要用于执行静态SQL语句，即SQL语句内容固定不变的语句。每执行一次都要对传入的SQL语句进行编译，效率比较低。

> `PreparedStatement`:某种情况下，SQL语句只是其中的参数不同，其他的子句都是相同的，这种适合用`PreparedStatement`语句对象。

> `PreparedStatement`语句能够预防SQL注入问题(安全性)。

> `PreparedStatement`是接口，继承`Statement`，SQL语句会提前编译，修改了常用方法，方法不需要参数。

> `PreparedStatement`实例包含事先编译好的SQL语句，SQL语句可以有一个或多个IN参数，IN参数的值是SQL语句创建时未被指定，此语句为每个IN参数保留一个问号(作为占位符)，每个问号的值必须在此语句被执行之前，通过适当的set XXX()方法提供。

### 重构员工表(`Statement`->`PreparedStatement`)

`Emp`->`EmpDao`->`EmpDaoImpl`->`TestCase`

#### 创建表

```sql
create table user_zhang(
id int,
    username varchar(10),
    password varchar(20)
);
insert into user_zhang values(1,'deo','111');
insert into user_zhang value(2,'sunny','222');
```

#### 登陆检测

```my
select * from user_zhang
where username='' and password='';
```

#### 查询结果判断

```mys
if(rs.next()){
//有数据
System.out.println("登陆成功")；
}else{
//没有数据
System.out.println("登陆失败");
}
```

#### 练习

> 完成登陆检测





