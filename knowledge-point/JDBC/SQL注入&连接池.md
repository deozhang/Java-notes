---
# SQL注入&连接池

## 1、SQL注入

> 通过把SQL命令插入到web表单提交或输入域名或页面请求查询字符串，最终达到欺骗服务器执行恶意SQL语句。

```
伪造密码：‘a’ or '1'='1'(永真式)
```

ps:语句对象

1)语句对象

1)语句对象有各自特点

2)编码不同

3)安全性

​	Statement：安全性

​	PreparedStatement:安全性，预防sql注入

## 2、连接池技术

>数据库连接的建立和关闭资源消耗比较大，传统方式访问数据库，一次数据库访问对应一个物理操作，每次操作数据库都要打开和关闭物理连接，系统性能受损。

解决方案：

数据库连接池，系统初始运行时，主动建立足够的连接，连接组成一个池，每次应用程序请求数据库连接时，无需重新打开连接，而是直接从池中取出已有的连接，使用完无需关闭连接而是直接归还连接。

连接池中连接的使用原则：

应用在启动时创建初始数目连接，当申请无连接或达到最小连接数，按照增量创建新的连接。

为确保连接池中最小连接数策略：

动态检查：

定时检查连接池，一旦发现数量小于最小连接，则补充新的连接，确保连接池的正常运转。

静态检查：

空闲连接不够时，系统才能检测到是否达到最小连接数，按需分配，用完归还，空闲超时连接时进行释放。

Apache DBCP连接池：

DBCP连接池是Apache的一个Java连接池开源项目，同时也是Tomcat使用的连接池组件。

jar包：

commons-dbcp-1.4.jar 连接池实现

commons-pool-1.5.jar 连接池实现依赖库

ps:

连接池是创建和管理连接的缓冲技术，将连接准备好被任何需要它的应用程序所使用。

通过DataSource获取连接

1)通过属性配置文件获取连接池相关参数

2)加载参数获取连接

ps:连接池相关参数

初始连接数：池启动时创建的连接数

最大空闲数：池中保持空闲状态的最大连接数

最小空闲数：池中保持空闲状态的最小连接数

最大连接数：同一时间可以从池中分配的最多连接数

超时时间：池在抛出异常之前的等待的最大毫秒值

## 3、事务

> 事务在数据库保证交易可靠的机制，JDBC支持数据库事务的概念，在JDBC中事务默认是自动提交的。

事务的特定：

原子性：事务必须以原子为工作单元，对于数据的修改要么一起成功，要么失败。

一致性：事务在完成时，必须全部数据保持一致的状态。

隔离性：由并发事务操作的修改必须与其他并发操作的修改隔离。

持久性：事务在完成之后，它对于系统的影响是永久的。

ps:

事务属于数据库的概念，JDBC能够支持事务，本质还是在数据库中实现的。

JDBC支持事务提供API：

设置事务的提交方式：默认时自动提交（true）
Connection.getAutoCommit();

设置事务的提交方式
Connection.setAutoCommit(false);//不自动提交

事务提交（手动提交）
Connection.commit();

事务回滚
Connection.rollback();
创建表
create table account(
  id char(1),
  money int
  );
insert into account values('a',1000);
insert into account values('b',2000);
Ａ账户
update account set money=money-500 where id='A';

事务自动提交 
1）没有异常
A账户减少，B账户增加（一起成功）
2）有异常
A账户减少，B账户没有变化（一个成功，一个失败）

事务不自动提交
1）没有异常
A账户减少，B账户增加（手动提交，一起成功）
2）有异常
A账户不变，B账户不变（一起失败）

## 4、批处理
批处理：发送到数据库作为一个单元执行的一组语句。

批处理能降低应用程序和数据库之间的交互，相比单个SQL语句处理，批处理更为有效。

批处理API：
addBatch(sql):Statement语句对象的方法，可以将多条待处理SQL语句添加到该语句对象列表中。

addBatch()：PreParedStatement语句对象的方法，可以将多条待处理SQL语句添加到该语句对象列表中。

executeBatch():把Statement和PreparedStatement语句对象列表中的全部SQL语句发送到数据库进行批处理。

clearBatch():清空语句对象列表中SQL语句。

ps:
如果对象中包含过多待处理SQL语句，可能出现内存溢出问题。建议及时处理SQL语句列表。	

//创建表 
create table stu_zhang(
id int primary key,
name varchar(10) not null
);
//批量增加数据(Statement)、
批量删除数据(PreparedStatement)

5、返回自动生成的主键值
Mysql数据库能够支持主键自增

//员工表中员工号添加主键
alter table emp_zhang add primary key(empno);
//员工表中员工号添加自增
alter table emp_zhang modify empno int auto_increment;

给部门表中的部门号添加主键自增
alter teble dept_zhang change deptno deptno int primary key auto_increment;

给员工表中部门号添加外键
alter table emp_zhang
add foreigh key(deptno)
references dept_zhang(deptno);

关联表的插入
不推荐。
插入部门表的同时往员工表中插入一条记录（将员工分配给该部门）。主表(dept_zhang)/从表(emp_zhang)关联关系，插入数据的完整性。
//部门表插入记录
insert into dept_zhang(dname,location) values (?,?);

//查询部门号
select deptno from dept_zhang where dname=?;

//员工表插入记录
insert into emp_zhang(ename,deptno) values (?,?);

//推荐方式
利用PreparedStatement的getGeneraedKey03方法，获取自增类型的数据，性能良好，只有一次数据库交互。

//核心代码
ps=con.PreparedStatement(sql,Statement.RETURN_GRNERATED_KEYS);
//执行
ps.executeUpdate();//插入 
//返回自增类型的数据  
ResultSet rs=ps.getGeneratedKeys();
//取部门号
if(rs.next()){
	int deptno=rs.getInt(1);
}

//添加部门信息，同时添加员工信息(将员工分配给该部门)
ps:两个insert操作
void deptAndEmp(Dept dept,Emp emp);


