一、约束条件
1）主键约束（Primary key简称PK）
主键约束=不能重复+不能为空

一张表中只能有一个主键，主键可以是一列或多列组合。

列级：
create table stu_zhang(
id int primary key,
name varchar(10)
);
insert into stu_zhang values (1001,'张三');
insert into stu_zhang values (1001,'李四');
insert into stu_zhang values (null,'张三');
表级：(了解)
drop table stu_zhang;

create table stu_zhang(
id int,
name varchar(10),
constraint stu_zhang_id_pk primary key(id)
);

ps:
约束命名：表名_列名_约束类型
insert into stu_zhang values (1001,'张三');
insert into stu_zhang values (1001,'李四');
insert into stu_zhang values (null,'张三');


列级：
drop table stu_zhang;

create table stu_zhang(
id int primary key auto_increment,
name varchar(10)
);
//测试主键自增
insert into stu_zhang values (1001,'张三');
insert into stu_zhang values (null,'李四');
insert into stu_zhang(name) values ('张三');

2)非空约束(not null简称NN)
非空约束定义方式只有一种：列级
drop table stu_zhang;

create table stu_zhang(
id int primary key auto_increment,
name varchar(10) not null
);
insert into stu_zhang values (1001,'张三');
insert into stu_zhang values (1002,null);

3)唯一约束(Unique 简称UK)
列级：
drop table stu_zhang;

create table stu_zhang(
id int primary key auto_increment,
name varchar(10) not null,
email varchar(20) unique
);

insert into stu_zhang values (1001,'张三','123.gmail.com');
insert into stu_zhang values (1002,'李四','123.163.com');
insert into stu_zhang values (1003,'张三',null);
insert into stu_zhang values (1004,'李四',null);
//控制对唯一约束没有影响。
insert into stu_zhang values (1005,'李四','123.163.com');
//email不能重复。
表级：
create table stu_zhang(
id int primary key auto_increment,
name varchar(10) not null,
email varchar(20) unique,
constraint stu_zhang_id_pk primary (id),
constraint stu_zhang_email_pk unique(email)
);

4)外键约束(Foreign key简称FK)
外键约束定义在两个表的两个字段上，用来保证这
两个字段的关系。
//创建部门表
create table temp_dept(
deptno int primary key auto_increment,
dname varchar(10) not null
);
//创建员工表
create table temp_emp(
empno int primary key auto_increment,
ename varchar(10) not null,
deptno int,
constraint temp_dept_deptno_fk 
foreign key(deptno) references temp_dept(deptno)
);

//往员工表插入数据
insert into temp_emp values(1001,'张三',100);
//往部门表插入数据
insert into temp_dept values(100,'研发部');

ps:
外键约束主要用于保证数据的完整性和一致性

添加外键约束，两个表在创建和插入数据时，
都有先后顺序（先有部门然后才能将员工分配给
该部门）

二、事务
事务时一组DML操作的逻辑单元，用于保证数据的一致性，
在事务内部组成事务的DML操作，要么一起成功提交，
要么被一起撤销。

事务处理语言：TPL
commit：提交
rollback：回滚
savepoint：保存点

事务的开始和终止：
开始：事务开始于上一个事务的结束或第一条DML操作。
终止：事务终止与显示操作（commit/rollback）

事务中的数据状态：
如果多个会话操作同一张表数据，
当用户和服务器连接成功后，服务器和客户端建立一个
会话（Session），客户端和服务器的交互都在此会话中
进行。

演示：
步骤1：打开会话A，创建表，插入数据不提交
create table temp(
id int
);
set autocommit=0;//不自动提价

insert into temp values(1);

步骤2：A会话中更新数据不提交
update temp set id=2;

步骤3：A会话更新数据不提交，B会话删除数据不提交
update temp set id=3;//A

set autocommit=0;//B 
delete from temp;

步骤4：A会话更新数据不提价，回滚，查询数据
update temp set ie=4;
rollback;
select * from temp;

总结：
a.事务内部数据的改变如果没有提价，只能在自己的当前会话中
看到数据改变，其他会话看不到数据的改变。
b.事务会对操作的数据进行加锁，不允许其他事务进行操作。
（A更新未提交，B会话删除会发生阻塞)
c.如果事务提交，数据的改变得到确认，其他会话可以看到数据改变；
数据上锁释放；保存数据的临时空间被释放。
d.如果事务进行了回滚，数据的改变被取消；数据上的锁
被释放；保存数据的临时空间被释放。

演示：保存点
drop table temp;
create table temp(
id int
);
set autocommit=0;
insert into temp values(1);
savepoint A;
insert into temp values(2);
savepoint B;
insert into temp values(3);
rollback to A;//回滚到保存点A
select * from temp;

ps：
回滚到保存点A，A之后的保存点会自动取消。
如果进行commit提交，那么回滚是无效

三、数据库中常用对象
1）表（Table）
表是关系型数据库的基本存储结构。
表是一个二维结构，由行和列组成。
横向为行也叫记录，纵向为列也叫字段。
ps:
表->实体对象
记录->具体实例对象
字段->对象的属性

2）视图（View）
视图是一个虚表（没有数据），其内容由查询定义。

视图是对应一条select语句，此语句得到的结果集赋予一个名字，
即视图的名字。可以像操作表一样操作视图。

//查询20号部门的员工信息
select empno,ename
from emp_zhang
where deptno=20;
+-------+--------+
| empno | ename  |
+-------+--------+
|  1004 | 郭靖       |
|  1005 | 黄蓉       |
|  1006 | 洪七公      |
+-------+--------+
//创建视图
create view view_emp as
select empno,ename
from emp_zhang
where deptno=20;
//查看视图
select * from view_emp;
+-------+--------+
| empno | ename  |
+-------+--------+
|  1004 | 郭靖       |
|  1005 | 黄蓉       |
|  1006 | 洪七公      |
+-------+--------+

说明：
视图的使用和表是相同的，视图的好处在于能够简化查询，隐藏数据表
中部分列，视图是不包含任何数据的，视图仅仅是基表的一个投影。

//更新基表，查看视图
update emp_zhang set ename='郭靖v' where empno=1004;

select * from view_emp;
//更新视图，查看基表
update view_emp set ename='郭靖' where empno=1004;

select empno,ename
from emp_zhang
where empno=1004;

ps:
基表进行DML操作会改变视图的显示，
对视图进行DML操作同样会改变基表的显示。视图只是基表的投影。

//删除视图
drop view view_emp;

3）索引(Index)
索引用于在数据库中加速表查询的数据库对象。
通过快速访问路径方式定位数据，可以减少磁盘的I/O操作，
提高查询效率。

//利用空间换取时间，使用索引占用空间
索引结构：数据+数据的地址

自动创建索引：主键约束和唯一约束
手动创建索引：
语法：
create index 索引名 on 表名（列名）;

//根据员工号查询员工信息
select ename
from emp_zhang
where empno=1004;

ps:
show variables like '%pro%';

set profiling=1;//设置开启

show profiles;//查看语句执行时间

//给员工表中empno添加索引
create index empno_index on emp_zhang(empno);

ps：
通过前后时间对比（加不加索引），演示效果不明显，由于数据量
比较小。
4）存储过程（Procedure）
存储过程是在大型数据库中，一组为完成特定功能的SQL语句。

存储过程存储在数据库中，经过一次编译后再次调用不需要再次编译，用户通过指定存储过程名字
并给参数（如果存储过程带有参数）来执行。

好处：
a.把复杂的操作存放在存储过程中，简化用户操作
b.简化变动时的修改
c.保证数据的完整性
d.提高应用程序性能

//创建存储过程
create procedure 存储过程名()
begin
...
end

//创建存储：查询员工表中最高薪水
delimiter //
create procedure maxSalary()
begin
select max(salary) from emp_zhang;
end
delimiter ;

call maxSalary();

drop procedure maxSalary;

ps:
生命分隔符：delimiter //
归还分隔符：delimiter ;

2.创建存储过程：带有输出参数
查询员工中最高薪水，最低薪水，平均薪水
delimiter //
create procedure getEmp(
out max_salary double(7,2),
out min_salary double(7,2),
out avg_salary double(7,2)
)
begin
select max(salary) into max_salary from emp_zhang;
select min(salary) into min_salary from emp_zhang;
select avg(ifnull(salary,0)) into avg_salary from emp_zhang;
end //
delimiter ;

//调用存储过程
call getEmp(@max_salary,@min_salary,@avg_salary)

//查看数据
select @max_salary,@min_salary,@avg_salary;

3.创建存储过程：带有输入输出参数
根据员工号查询员工姓名
delimiter //
create procedure getEname(
in id int,
out name varchar(10)
)
begin
select ename into name from emp_zhang
where empno=id;
end //
delimiter ;

//调用存储过程
call getEname(1004,@name);

//查看数据
select @name;

四、用户管理
mysql>use mysql;//mysql数据库下用户管理
//创建用户
create user 'deo'@'localhost' identified by 'd';
//授予权限
grant select,insert,update,delete on jsd.* to 'deo'@'localhost'; 
//查看用户
select user();	
//回收权限
revoke select on jsd.* from 'deo'@'localhost'; 
//删除用户
drop user deo@localhost



































