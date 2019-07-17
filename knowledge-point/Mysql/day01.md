行Row，也叫Record，用于表示实体数据。
列Column，也叫字段，用于表示实体属性。

SQL语言：结构化查询语言(Structured Query Language)

一、SQL划分
数据定义语言:DDL(Date Definition Language)
负责数据库对象的定义(比如：表)的定义
常用语句：[针对表结构而言]
create:创建数据库对象(创建表结构)
alter:修改表结构
drop:删除表结构
truncate:清空表数据，保留表结构

数据操纵语言:DML(Data Manipulation Language)
实现对表中数据增加、更新、删除
常用语句：[针对表数据而言]
insert:增加数据
update:更新数据
delete:删除数据

数据查询语言：DQL(Data Query Language)
实现对表中数据查询操作
常用语句：
select：查询语句

数据控制语言：DCL(Data Control Language)
实现权限的授予和回收
常用语句：
grant:授予权限
revoke:回收权限
create user:创建用户

事物处理语言：TPL(Transaction Processing Language)
跟DML数据操纵语言结合使用，用于进行确认或取消操作
常用语句：
commit：确认操作
rollback：回滚操作
savepoint：保存点

二、Mysql数据库
1)特性
开源免费、支持多线程处理，支持大型的数据库、为多种编程(Java、C#)提供API、多种数据库
连接程序。

2)查看数据库
show databases;

3)创建数据库(设置默认编码)
create database 数据库名
default character set utf8;

4)使用指定的数据库
use 数据库名;

5)查看表
show tables;

6)创建表
create table 表名(
字段名 类型,
字段名 类型
);

7)查看表结构
desc 表名;
或
show columns from 表名;

8)查看系统当前时间
select now() from dual;
或
select now();

dual表是Oralcle提供的最小的工作表，只有一行一列，具有某些特殊功能，
往往用于测试使用，mysql数据库也可以使用。

9)查看编码设置
show variables like 'character%';

//设置编码的统一(客户端，连接，结果)
set names gbk;//当前会话有效，每次打开窗口都要执行一次

三、Mysql常用数据类型
1)数值类型
int:占4个字节
float(m,d):占4个字节
double(m,d):占8个字节，m表示数字总位数，d表示数字的小数位数(小数位会自动四舍五入处理)
如：
double(5,3)-->表示的最大数99.999

2)字符类型
char(n):定长字符串,n表示字符长度，长度不足n时则补空格(方便查询)
varchar(n):变长字符串，分配n个字符串，实际占几个字符就占多大空间(节省空间)
ps:
字符长度：不区分中英文
字符串类型必须加引号(单、双引号都可以)

3)日期类型
date：日期数据
datetime:日期和时间数据

四、表的结构操作(DDL)
1)创建表的结构
语法：
create table 表名(
字段名 类型,
字段名 类型
);
ps:注意点
a.关键字create table
b.表名不能重复
c.字段之间用逗号隔开，最后一个字段不需要逗号
d.字段可以添加默认值用default

//创建部门表(dept_zhang)
分析：
部门号：10 20 30
部门地址：'研发部' '行政部'
部门名称：'南京' '苏州'

create table dept_zhang(
deptno int,
dname varchar(6),
location varchar(8)
);
ps:表可以重命名
rename table 原名字 to 新名字;
2)修改表结构
//增加字段
语法：
alter table 表名 add 字段 类型;
给部门表增加一个'描述'的字段(desc->varchar(10));
alter table dept_zhang add des varchar(10);
//修改字段(字段类型及长度，字段名)
语法：
alter table 表名 modify 字段名 新的数据类型;
给部门表中'描述'字段varchar(10)->char(20);
alter table dept_zhang modify des char(20);
ps:
如果表中没有数据，任意修改字段类型及长度。
但是如果表中有数据，修改有可能会失败(比如长度范围由大变小)。

修改字段名
alter table 表名 change 字段名 新字段名 数据类型;
alter table dept_zhang change des dd varchar(10);

//删除字段
语法：
alter table 表名 drop 字段名;
删除字符表中的描述字段
alter table dept_zhang drop dd;

3)删除表结构
//彻底删除，删除数据同时删除表结构
drop table dept_zhang;//常用
//清空表数据，保留表结构
truncate table dept_zhang;

总结：DDL
create:创建表结构
alter：修改表结构(add增加字段、modify修改字段类型及长度、change修改字段名、drop删除字段)

五、表数据操作(DML)
ps:语法必须记住！！！
1)增加数据
语法：
//方式一：全部字段 按照表结构一一对应给值。
insert into 表名 values(值1,值2...);

往部门表中插入一条记录
insert into dept_zhang values (10,'研发部'，'南京');//字符串类型要加引号
查看部门表中数据
select deptno,dname,location from dept_zhang;

ps:
Mysql控制台默认时自动提交的
//设置不自动提交
set autocommit=0;
commit;//手动提交

//方式二：指定字段，按照给定字段一一对应给值
insert into 表名(字段1,字段2) values (值1,值2);
往部门表中插入数据
insert into dept_zhang(deptno,dname,location) values(12,'外交部','北京');
2)更新数据
语法：
update 表名 set 字段名=值,字段名=值 where 条件;
ps:
如果没有where则表示更新表中的全部记录
更新部门表中的15号部门，部门地址改为'宿州'

3)删除数据
语法：
delete from 表名 where 条件;
ps:
如果没有where则表示删除表中的全部数据;
//插入记录
50 '后勤部'
insert into dept_zhang values(50,'后勤部',null);
insert into dept_zhang values(deptno,dname) values(50,'后勤部');
删除部门中50号部门信息
delete from dept_zhang where deptno=50;

补充：
删除数据(两者效果相同)
//DML 确认提交(默认自动提交) 如果未提交可以回滚 可以带where条件
delete from dept_zhang;
//DDL 立即生效 清空表数据
truncate table dept_zhang;

分析员工表(emp_zhang)
员工号：empno	int
员工姓名：ename		varchar
员工职位：position		varchar
员工薪水：salary		double(7,2)
员工的奖金：bonus	double
员工的入职日期：hiredate	date
员工的领导:leader	int
员工的门号：deptno		int

分析每个字段对应的数字类型及长度，完成表结构创建并插入数据。
//创建数据库
create table emp_zhang(
empno int,
ename varchar(6),
position varchar(10),
salary double(7,2),
bonus double(5,2),
hiredate date,
leader int,
deptno int
);
