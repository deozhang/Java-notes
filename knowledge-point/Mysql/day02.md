回顾:
SQL划分:
DDL:数据定义语言(结构) create/alter[add/drop/modify/change]/drop/truncate
DML:数据操纵语言(数据) insert/update/delete[语法结构]
TPL:事务处理语言 commit/rollback/savapoint
DQL:查询操作select...from[重点]
DCL:权限grant/revoke/create user

=========================================================================
一.基础查询
1)简单查询
select empno from emp_zhang;//单列检索
select empno,ename from emp_zhang;//多列,逗号隔开
select * from emp_zhang;//检索所有列
ps:
通配符*查询会降低查询速度和影响应用程序性能,建议少用.

//查询1005员工信息
select empno,ename 
from emp_zhang 
where empno=1005;
ps:
where:表示行(记录)的过滤

=		等于
!=或<>  不等于
>		大于
>=		大于等于

2)列别名
查询员工的薪水和年薪(salary*12)
select empno,ename,salary,salary*12 as year_salary //as可以省略
from emp_zhang;

ps:使用限定的表
select ename from emp_zhang;
或
select e.ename from emp_zhang;
 
3)
查询员工的月薪(salary+bonus)
select ename 姓名,salary+bonus 月薪
from emp_zhang;

select ename 姓名,salary 薪水,bonus 奖金,salary+bonus 月薪
from emp_zhang;//查询结果有问题

3)空值NULL
结论:
a.空值参与算术运算时结果为空
b.任何数据类型都可以取空值
c.空值参与连接操作(concat(a,b))时结果为空

4)空值处理函数
ifnull(d1,d2):若d1为空则取d2代替,反之如果d1不为空,直接取d1的值

select ename 姓名,salary 薪水,bonus 奖金,salary+ifnull(bonus,0) 月薪
from emp_zhang;

5)插入记录
empno:1013
ename:'欧阳峰'
其他数据都为空

//全部字段
insert into emp_zhang 
values(1013,'欧阳峰',null,null,null,null,null,null);
//指定字段
insert into emp_zhang(empno,ename) 
values (1013,'欧阳峰'); 

//查询员工的姓名/职位/要求没有职位的显示'No Position'
select ename,ifnull(position,'No Position') 职位 
from emp_zhang;

6)连接操作
查询员工信息,要求将员工的姓名和职位连接在一起
如:'张三丰Analyst'
select empno,concat(ename,position) message
from emp_zhang;//'欧阳峰'position为空,连接操作结果为空

select empno,concat(ename,ifnull(position,'No Position')) message
from emp_zhang;

7)去重
distinct:实现去重,只能跟在select后面
查询有哪些职位
select position 
from emp_zhang;//数据重复

select distinct ifnull(position,'No position') 
from emp_zhang;

查询每个部门不重复的职位
select distinct deptno,position
from emp_zhang;//需要对两个字段进行联合去重,表示全部列的唯一组合

8)大小写
Mysql默认查询不区分大小写,如果需要区分,必须在创建表时通过binary标识敏感数据.
ps:
create table temp(
name vachar(10) binary
);
查询职位为'Analyst'的员工信息
select ename,position
from emp_zhang 
where position='Analyst';

SELECT ename,POSITION
from emp_zhang 
where position='analyst';//mysql默认不区分大小写

SELECT ename,POSITION
from emp_zhang 
where binary position='analyst';//匹配不到数据

9)介于两者之间
between 低值 and 高值
闭区间:[低值,高值]
查询薪水大于等于5000并且小于等于10000的员工信息
ps:
'并且'使用and关键字
'或者'使用or关键字
select empno,ename,salary
from emp_zhang
where salary>=5000 and salary<=10000; 

select ename,salary
from emp_zhang
where salary between 5000 and 10000;

查询入职日期在2009年的员工姓名和入职日期
select empno,ename,hiredate
from emp_zhang
where hiredate between '2009-01-01' and '2009-12-31'; 

select empno,ename,hiredate
from emp_zhang
where date_format(hiredate,'%X')='2009';

10)IN使用
in(列表项):判断等于列表项中任意一项,即满足一个即可


查询职位是'Analyst'或'Manager'的员工姓名和职位
select ename,position
from emp_zhang
where position='Analyst' or position='Manager';
或者
select ename,position
from emp_zhang
where position in('Analyst','Manager');
改动
select ename,position
from emp_zhang
where position in('Analyst','Manager',null);
//列表项中增加空值,没有影响结果.'欧阳峰'position为空没有被查询出来

ps:
a.使用in时列表项中有空值对结果没有影响
b.空值不能用等于或不等于跟任何数据(包括本事)进行比较

IN等价于=any

11)模糊查询
使用like关键字并结合通配符表示
_表示一个字符
%表示0到多个字符

查询员工姓名中包含'张'字的员工信息
select empno,ename
from emp_zhang
where ename like '%张%';

查询职位中包含'sales'的员工姓名和职位
select ename,position
from emp_zhang
where position like '%sales%';

查询职位中第二个字符是'a'的员工的姓名和职位
select ename,position
from emp_zhang
where position like '_a%';

//插入记录
insert into emp_zhang(empno,ename)
values(1014,'张三%');

查询员工姓名中包含'%'员工信息
select empno,ename
from emp_zhang
where ename like '%\%%';

select empno,ename
from emp_zhang
where ename like '%/%%' escape '/';
ps:
escape:转义字符后面的_或%,使其不作为通配符,而是普通字符匹配

通配符使用比较影响查询速度,花费时间比较长,不要过度使用.

12)
空值不能用等于或不等于跟任何数据(包括自己)进行比较

测试空值:
肯定形式用is null
否定形式用is not null

查询哪些员工没有奖金
select empno,ename,bonus
from emp_zhang
where bonus is null;

13)查询中否定形式
查询哪些员工有奖金
select empno,ename,bonus
from emp_zhang
where bonus is not null;

查询薪水不在5000到10000之间的员工姓名和薪水
select ename,salary
from emp_zhang
where salary not between 5000 and 10000;//临界值否定时取不到

查询不是20号部门和30号的员工信息
select deptno,ename
from emp_zhang
where deptno!=20 and deptno!=30;

not in(列表项):判断不等于列表项中所有项,要求满足全部
select deptno,ename
from emp_zhang
where deptno not in(20,30);\

改动
select deptno,ename
from emp_zhang
where deptno not in(20,30,null);
//使用not in时列表项中有空值,结果查询不到任何记录.列表项中的空值必须要去掉

ps:[重要]
in(列表项):肯定 判断等于列表项中任意一项.列表项中有空值对结果没有影响.

not in(列表项):否定 判断不等于列表项中所有项.列表项中有空值对结果有影响(查询不到任何记录),
使用not in时列表项中空值必须去掉.

二.查询中常用函数
单行函数:每一行数据处理后返回一个结果
1)数字函数
round(数字,保留到小数点后指定的位数):用于对数字进行四舍五入处理保留到小数点后制定位数.
如果保留到整数位,第二个参数可以用0或者不写.
//测试
select round(123.456,2) from dual;(mysql中可以省略from dual)

truncate(数字,截取到小数点后制定的位数):用于对数字进行截取操作.
如果截取到整数位,第二个参数可以用0表示,0不可以省略.
//测试
select truncate(123.456,2);

2)拼接(连接操作)
concat(a,b,c):用于对多个字符串进行拼接

查询员工姓名和职位,要求数据显示格式如下:
'张三丰(Analyst)'
select empno, 
concat(ename,'(',ifnull(position,'No position'),')') message
from emp_zhang;

3)去除空格
trim(字符数据):去掉左右空格
形如:'( abc )'
select concat('(',trim(' abc '),')');
//去左边空格
select concat('(',ltrim(' abc '),')');
//去右边空格
select concat('(',rtrim(' abc '),')');

4)文本处理函数
upper(小写):转大写
lower(大写):转小写
//测试
select upper('abc');

length(字符):返回字符对应的字节长度
select ename,length(ename)
from emp_zhang;

substring(字符,起始位置,最大的字符数量)
select ename,substring(ename,2,1)
from emp_zhang;

5)数据处理函数
abs(数据):返回绝对值
rand():返回0-1之间的随机数
sqrt(数据):返回数据的平方根
pow(x,y):返回x的y次方
mod(x,y):返回x除以y的余数

6)处理日期的函数
now():返回当前系统的时间
date(日期时间):返回日期数据
time(日期时间):返回时间数据
year(日期时间):返回年份

//测试
select year(now());

adddate():增加一个日期(天day,月month,周week)
//interval 间隔
select adddate('2019-07-09',interval 3 day);
或者
//默认增加天整数
select date_add('2019-07-09',3);

date_format(日期,格式):格式化日期数据
//测试
select date_format(now(),'%x-%m-%d %H:%i:%s');

7)其他函数
case..when:分支条件语句
语法结构:
case 字段
	when 条件1 then 值1
	when 条件2 then 值2
	else 其他值 end
	
根据员工的职位计算加薪之后的薪水值
要求:
如果职位是'Analyst'加薪20%
如果职位是'Programmer'加薪5%
如果职位是'Clert'加薪2%
其他职位薪水不变
select ename,position,salary,
case position
when 'Analyst' then salary*1.2
when 'Programmer' then salary*1.05
when 'Clert' then salary*1.02
else salary end
new_salary
from emp_zhang;

组函数(聚合函数):多行数据处理后返回一个结果
	count(列名|*):求记录数
	sum(列名):求和
	avg(列名):求平均
	max(列名):求最大值
	min(列名):求最小值
	
//测试
select count(empno) from emp_zhang;//14
select count(position) from emp_zhang;//12忽略了空值
select count(*) from emp_zhang;// *不忽略空值
查询员工的薪水总和
select sum(salary) from emp_zhang;
查询员工的人数/薪水总和/平均薪水
select count(empno) 员工人数,sum(salary) 薪水总和,avg(salary) 平均薪水 from emp_zhang;
//avg会忽略空值,对结果有影响
//修改
select count(empno) 员工人数,sum(salary) 薪水总和,avg(ifnull(salary,0)) 平均薪水 from emp_zhang;

select max(salary),min(salary)
from emp_zhang;
//改动
mysq中不会报错,其他数据库不支持
select ename max(salary),min(salary)
from emp_zhang;//避免使用该写法

总结:
count/sum/avg/max/min如果函数中写列名,默认是忽略空值的,count(*)不忽略空值.

sum/avg只能用于处理数值类型

















