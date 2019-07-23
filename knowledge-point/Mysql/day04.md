关联子查询:嵌套的子查询不是独立语句,依赖主查询
1)查询哪些员工的薪水比本部门的平均薪水低
select ename,salary,deptno
from emp_zhang
where salary<(本部门平均薪水);

select ename,salary,deptno
from emp_zhang e
where salary<(
	select avg(ifnull(salary,0))
	from emp_zhang
	where deptno=e.deptno
);//e.deptno表示动态数据,由主查询传递过来的

关联子查询执行过程:
先执行主查询->将参数传递给子查询(依赖)->执行子查询->返回结果给主查询->
再执行主查询

//查询哪些人有下属
分析:
哪些人有下属->找领导
//非关联子查询
select empno,ename
from emp_zhang
where empno in(
select leader from emp_zhang
);
//关联子查询
select empno,ename
from emp_zhang e
where exists(
select 1 
from emp_zhang
where leader=e.empno
);

说明:
exists关键字用来判断查询有没有结果返回.
满足某种关系有数据返回则true,关系不满足没有数据返回则false.
exists不关心子查询返回的结果,所以子查询中select后面写什么都可以,
通常直接用1表示.

3)查询哪些人没有下属(否定形式)
//非关联子查询
select empno,ename
from emp_zhang
where empno not in(
select leader from emp_zhang
where leader is not null
);//使用not in时列表项中的空值必须要去掉

//关联子查询
select empno,ename
from emp_zhang e
where not exists(
select 1 
from emp_zhang
where leader=e.empno
);

4)查询哪些部门有员工(肯定)
分析:
满足部门表中部门号出现在员工表中
//非关联子查询
select deptno,dname
from dept_zhang
where deptno in(
select deptno
from emp_zhang
);
//关联子查询
select deptno,dname
from dept_zhang d
where exists(
select 1 from emp_zhang
where deptno=d.deptno
);

5)哪些部门没有员工(否定)
insert into dept_zhang values(50,'后勤部',null);
//非关联子查询
select deptno,dname
from dept_zhang
where deptno not in(
select deptno
from emp_zhang
where deptno is not null
);
//关联子查询
select deptno,dname
from dept_zhang d
where not exists(
select 1 from emp_zhang
where deptno=d.deptno
);
ps:
关联子查询中嵌套的子查询执行多次

组合查询
组合查询规则
a.组合查询由两条或两条以上的select语句组成的,并以union分隔
b.被union连接起来的不同查询的结果必须包含相同的列,表达式,组函数(两个结果集结构相同)

//查询10号部门的员工姓名和薪水
select ename,salary
from emp_zhang
where deptno=10;
+--------+----------+
| ename  | salary   |
+--------+----------+
| 张三丰 | 99999.99 |
| 张无忌 |  5000.00 |
| 杨过   |  8000.00 |
| 张张   |     NULL |
+--------+----------+
//查询薪水大于6000的员工姓名和薪水
select ename,salary
from emp_zhang
where salary>6000;
+--------+----------+
| ename  | salary   |
+--------+----------+
| 张三丰 | 99999.99 |
| 杨过   |  8000.00 |
| 乔峰   |  8000.00 |
| 段誉   | 15000.00 |
| 孙悟空 | 50000.00 |
| 燕小六 | 12000.00 |
| 张无忌 |  8000.00 |
+--------+----------+	

组合查询
select ename,salary
from emp_zhang
where deptno=10
union
select ename,salary
from emp_zhang
where salary>6000;//union会自动去重
+--------+----------+
| ename  | salary   |
+--------+----------+
| 张三丰 | 99999.99 |
| 张无忌 |  5000.00 |
| 杨过   |  8000.00 |
| 张张   |     NULL |
| 乔峰   |  8000.00 |
| 段誉   | 15000.00 |
| 孙悟空 | 50000.00 |
| 燕小六 | 12000.00 |
| 张无忌 |  8000.00 |
+--------+----------+
select ename,salary
from emp_zhang
where deptno=10
union all
select ename,salary
from emp_zhang
where salary>6000;//union all不去重
+--------+----------+
| ename  | salary   |
+--------+----------+
| 张三丰 | 99999.99 |
| 张无忌 |  5000.00 |
| 杨过   |  8000.00 |
| 张张   |     NULL |
| 张三丰 | 99999.99 |
| 杨过   |  8000.00 |
| 乔峰   |  8000.00 |
| 段誉   | 15000.00 |
| 孙悟空 | 50000.00 |
| 燕小六 | 12000.00 |
| 张无忌 |  8000.00 |
+--------+----------+

三.分页查询
mysql分页实现使用limit关键字,限制查询记录数的检索语句.
语法:
select 字段 from 表名 limit 数量;
select 字段 from 表名 limit 开始行,数量;//常用(开始行从0开始计数)

//测试
select empno,ename
from emp_zhang
limit 5;
+-------+--------+
| empno | ename  |
+-------+--------+
|  1001 | 张三丰 |
|  1002 | 张无忌 |
|  1003 | 杨过   |
|  1004 | 郭靖   |
|  1005 | 黄蓉   |
+-------+--------+
select empno,ename
from emp_zhang
limit 3,5;//从第四行开始查找,找5条记录
+-------+--------+
| empno | ename  |
+-------+--------+
|  1004 | 郭靖   |
|  1005 | 黄蓉   |
|  1006 | 洪七公 |
|  1007 | 韦小宝 |
|  1008 | 乔峰   |
+-------+--------+
//找规律
每页显示5条记录
第1页 0-4   limit 0 , 5
第2页 5-9   limit 5 , 5
第3页 10-14 limit 10, 5

pageSize:每页的记录数
page:查询指定的页数
//计算公式(每页开始行)
int begin=(page-1)*pageSize

四.表间关联查询
内连接:
语法:[]可选项
表1 [inner] join 表2 on 条件 

//查询员工姓名和其部门的名字
分析:结果集中包含员工姓名(emp_zhang)和部门姓名(dept_zhang)
select ename,dname
from emp_zhang e inner join dept_zhang d
on e.deptno=d.deptno;//inner可以省略
ps:内连接的结果集中数据一定是在两个表中都能找到匹配记录

补充:(了解)
select ename,dname
from emp_zhang e, dept_zhang d
where e.deptno=d.deptno; //先将两个表进行笛卡尔积再过滤
ps:
如果不加where条件的联结,得到的是笛卡尔积的结果
检索结果的行数=第一张表的行数*第二张表的行数

//查询员工的姓名和其领导的名字
select e1.ename 员工,e2.ename 领导
from emp_zhang e1,emp_zhang e2
where e1.leader=e2.empno ;
或者
select e1.ename 员工,e2.ename 领导
from emp_zhang e1 inner join emp_zhang e2
on e1.leader=e2.empno;
+--------+--------+
| 员工   | 领导   |
+--------+--------+
| 张无忌 | 张三丰 |
| 郭靖   | 黄蓉   |
| 洪七公 | 黄蓉   |
| 乔峰   | 韦小宝 |
| 小龙女 | 乔峰   |
| 孙悟空 | 段誉   |
| 燕小六 | 段誉   |
| 张无忌 | 欧阳峰 |
+--------+--------+

说明:
表1 join 表2 on 条件
a.表1为驱动表,表2为匹配表
b.执行过程:遍历驱动表在匹配表中找匹配记录
c.内连接结果集特点:匹配上的记录保留,匹配不上的记录丢掉
d.等值连接中(条件中用等号),驱动表和匹配表可以互换

//查询员工姓名和其部门的名字,要求没有部门的员工也要被查询出来
分析:
员工=有部门的员工(内连接)+没有部门的员工(基础查询)
select ename,dname
from emp_zhang e join dept_zhang d
on e.deptno=d.deptno
union all
select ename ,'No dept'
from emp_zhang
where deptno is null;

外连接:严格区分哪个表是驱动表
语法:[]可选项
//左外连接(以左边为驱动表)
表1 left [outer] join 表2 on 条件
//右外连接(以右边为驱动表)
表1 left [outer] join 表2 on 条件
//查询员工姓名和其部门的名字,要求没有部门的员工也要被查询出来
分析:查询全部员工,那么员工表应该作为驱动表
select ename,ifnull(dname,'No Dept')
from emp_zhang e left outer join dept_zhang d
on e.deptno=d.deptno;
//左外连接,右外连接可以互换,必须明确哪个表时驱动表
select ename,ifnull(dname,'No Dept')
from dept_zhang e right outer join emp_zhang d
on e.deptno=d.deptno;
ps:
外连接:遍历驱动表在匹配表中找匹配记录,匹配上的记录保留,匹配不上的记录匹配一行空行
//查询员工的姓名和其部门的名字,要求没有员工的部门也要被查询出来
分析:
查询全部的部门,部门表为驱动表

select dname,ifnull(ename,'No Emp')
from emp_zhang e right join dept_zhang d
on e.deptno=d.deptno;

ps:
外连接特点:
如果驱动表在匹配表中找不到匹配,则匹配一行空行
驱动表中数据会全部出现在外连接的结果集中.

外连接结果集=内连接的结果集+匹配不上的记录

//查询哪些部门没有员工
外连接
部门=有员工的部门+没有员工的部门
select dname,ename 
from dept_zhang d left join emp_zhang e 
on d.deptno=e.deptno;//通过外连接查询全部部门信息

select dname,ename 
from dept_zhang d left join emp_zhang e 
on d.deptno=e.deptno
where ename is null;

明确哪个表是驱动表(哪个表的数据全部出现在外连接的结果集中,该表作为驱动表)
外连接的本质:驱动表中数据会全部出现在外连接的结果集中

注意点:
a.不要关联不必要的表,处理关联非常消耗资源
b.关联的表越多,可能导致性能下降
c.获取同样的结果,可能存在多种SQL的实现方式,找最优的解决方式






















