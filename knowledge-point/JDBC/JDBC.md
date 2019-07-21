# JDBC技术

> Java Database Connectivity:Java访问数据库的解决方案。  
> 希望以相同的方式访问不同的数据库，以实现与具体数据库无关的java操作。

> JDBC定义一套标准的接口，即访问数据库API。不同的数据库厂商根据各自数据库特点去实现接口，从而达到JAVA程序的访问。

## JDBC接口
`DriverManger`:驱动管理
`Connection`：连接接口
`Statement`：语句接口
`PreparedStatement`
`ResultSet`:结果集

## JDBC工作过程：[重要]
1)加载驱动创建连接
2)创建语句对象
3)执行SQL语句
4)处理结果集(查询操作)
5)关闭资源

## 实战演练：(员工表`emp_zhang`)//TODO TEST
ps:
表->封装实体对象
记录->具体对象实例
字段->实体属性

创建包：分包

com.xms
        .entity
        .dao
            EmpDao
        .test


#### 操作：(增删改查)
1. 查询全部员工信息

  ```mysql
  select * from emp_zhang;
  List<Emp> findAll();
  ```

2. 根据员工号查询员工信息

  ```mysql
  select * from emp_zhang where empno=1004;
  emp findByEmpno(int empno);
  ```

  

`Connection`只是接口，真正的实现由数据库厂商提供的驱动包完成。
`Statement` 声明对象。
`ResultSet` 执行Sql语句

` ResultSet re = st.executeQuery(sql);`//查询
` int i = st.executeUpdate(sql);`//增加，更新，删除

结果存放在ResultSet对象的一系列行中，最初位于行首。
rs.next()用于在行间移动
rs.getXXX(数字|字段名)用于取数据

3. 增加一条员工信息。

  ```mysql
  insert into emp_zhang values(1002,'张三','Clerk',1200,600,日期,1013,10);
  void insertEmp(Emp emp);
  ```

4. 更新一条记录

5.删除一条记录

```mysql
delete from emp_zhang where empno=1022;

int[] a = new int[5]{1, 2, 3, 4, 5};//错
```



>Cannot define dimension expressions when an array initializer is provided

int[] a = new int[5];//错
