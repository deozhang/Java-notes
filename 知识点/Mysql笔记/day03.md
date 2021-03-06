一.自定义函数(了解)
//查询当前系统时间
SELECT DATE_FORMAT(NOW(),'%X年-%m月-%d日 %H时:%i分:%s秒');
1)创建不带参数的自定义函数
CREATE FUNCTION F1() RETURNS VARCHAR(30)
RETURN DATE_FORMAT(NOW(),'%X年-%m月-%d日 %H时:%i分:%s秒');
//使用
SELECT F1();
//删除
DROP FUNCTION F1;

2)创建带参数的自定义函数
CREATE FUNCTION F2(NUM1 INT ,NUM2 INT) RETURNS DOUBLE(4,2) RETURN (NUM1+NUM2)/2;
//使用
SELECT F2(10,15);

二.正则表达式  REGEXP
mysql支持正则表达式只是正则的一个很小的子集.
//查询员工表中姓名包含'张'的所有记录
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '张';
//查询员工表中姓名包含'张'或'郭'的所有记录
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '张|郭';

INSERT INTO EMP_ZHANG(EMPNO,ENAME)
VALUES (1015,'1张三');
INSERT INTO EMP_ZHANG(EMPNO,ENAME)
VALUES (1016,'2张三');
INSERT INTO EMP_ZHANG(EMPNO,ENAME)
VALUES (1017,'3张三');

//查询员工表中姓名包含'1张三'或'2张三'或'3张三'
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '(1|2|3)张三';
或者
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '[123]张三';//or匹配
或者
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '[1-3]张三';//匹配范围

INSERT INTO EMP_ZHANG(EMPNO,ENAME)
VALUES (1018,'张三.');
//查询员工表中姓名包含'.'
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '\\.' ;

ps:
匹配任意的字母:[a-zA-Z]
匹配任意数字:[0-9]

查询员工表中姓名包含数字的所有记录
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '[0-9]' ;

ps:匹配多个实例
元字符  描述
* 		0或多个字符
+		1或多个匹配
?		0或1个匹配
{n}		指定数量的匹配
{m,n}   匹配数量的范围
{n,}	不小于指定数量的匹配
^		文本的开始
$ 		文本的结束

//查询员工表中姓名包含1到3的任意数字,后面跟一个'张三'的所有记录
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '[1-3]张三{1}' ;

INSERT INTO EMP_ZHANG(EMPNO,ENAME)
VALUES (1019,'.张三');
//查询员工表中姓名包含'.',后面跟一个'张三'的所有记录
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '\\.张三{1}' ;

//查询员工表中姓名起始包含'.'或1或2或3的所有记录
SELECT ENAME
FROM EMP_ZHANG
WHERE ENAME REGEXP '^[123\\.]' ;

三.排序子句
排序:对结果集进行排序(先有结果集再排序)
排序子句:order by 列名(一般为数值或日期)
排序规则:asc    升序(默认)
		 desc   降序
		 
//查询信息要求按照薪水由低到高进行排序
SELECT ENAME,IFNULL(SALARY,0)
FROM EMP_ZHANG
ORDER BY SALARY ASC;//升序 ASC可以省略
PS:
空值参与排序被看作最小值
//按照部门号升序排序,同一个部门按照薪水降序排序,没有部门的不参加排序
SELECT DEPTNO,EMPNO,ENAME,SALARY
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
ORDER BY DEPTNO ASC,SALARY DESC;//列名
//使用列别名进行排序
SELECT DEPTNO D,EMPNO,ENAME,SALARY S
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
ORDER BY D ASC,S DESC;
//使用数字进行排序
SELECT DEPTNO,EMPNO,ENAME,SALARY
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
ORDER BY 1 ASC,4 DESC;

执行顺序:
from(检索指定表)->where(记录的过滤)->select(结果集)->order by(排序)


ps:
排序语句的执行在select之后,因此排序可以用列名/列别名/表达式/函数,还可以使用数字
(查询结果集返回字段对应的顺序,第一列用1表示)进行排序

补充内容:
//根据员工的姓名进行排序
//按照汉字首字母排序(进行字符集转换)
SELECT ENAME
FROM EMP_ZHANG
ORDER BY CONVERT(ENAME USING GBK);

四.分组子句
分组:group by列名

//查询每个部门的最高薪水和最低薪水,要求没有部门的不算在内
SELECT DEPTNO,MAX(SALARY),MIN(SALARY)
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO;

//查询每个部门的薪水总和和平均薪水,要求没有部门的不算在内
SELECT DEPTNO,SUM(SALARY),AVG(SALARY)
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO;

//按照职位分组,每个职位的最高,最低薪水,人数总和,要求没有职位的不算在内
SELECT POSITION,MAX(SALARY),MIN(SALARY),COUNT(EMPNO)
FROM EMP_ZHANG
WHERE POSITION IS NOT NULL
GROUP BY POSITION;

PS:
分组查询语句中,select后面的列要么被主函数包围,要么出现在GROUP BY之后.

HAVING字句:分组之后的再过滤

//查询平均薪水大于5000的部门号和平均薪水,要求没有部门的不算在内
SELECT DEPTNO,AVG(IFNULL(SALARY,0))
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
HAVING AVG(IFNULL(SALARY,0))>5000;

PS:
WHERE:行记录的过滤
HAVING:分组之后的过滤(结合分组使用)

//查询哪些职位的人数超过2个人,要求没有职位的不算在内
SELECT POSITION,COUNT(EMPNO)
FROM EMP_ZHANG
WHERE POSITION IS NOT NULL
GROUP BY POSITION
HAVING COUNT(EMPNO)>2;

//查询哪些职位的人数超过2个人,要求没有职位的不算在内,计算每个职位的平均薪水,按照平均
薪水降序排序
SELECT POSITION,COUNT(EMPNO),AVG(IFNULL(SALARY,0)) AVG_SALARY
FROM EMP_ZHANG
WHERE POSITION IS NOT NULL
GROUP BY POSITION
HAVING COUNT(EMPNO)>2
ORDER BY AVG_SALARY DESC;

总结:基础查询
写法顺序:SELECT->FROM->WHERE->GROUP BY->HAVING->ORDER BY
执行顺序:FROM(检索指定表)->WHERE(记录过滤)->GROUP BY(分组)
		->HAVING(分组后过滤)->SELECT(结果集)->ORDER BY(排序)

SELECT DEPTNO,ENAME
FROM EMP_ZHANG
GROUP BY DEPTNO;

补充内容:[]可选项
GROUP_CONCAT([DISTINCT] 字段 [SEPARATOR '分隔符'] [ORDER BY '字段' ASC/DESC])

//返回一对多数据,数据在同一行显示,逗号隔开(默认)
SELECT DEPTNO,GROUP_CONCAT(ENAME)
FROM EMP_ZHANG
GROUP BY DEPTNO;
//数据用指定的符号进行分割
SELECT DEPTNO,GROUP_CONCAT(ENAME SEPARATOR ';')
FROM EMP_ZHANG
GROUP BY DEPTNO;

INSERT INTO EMP_ZHANG(EMPNO,ENAME,POSITION,DEPTNO) VALUES(1020,'张张','Analyst',10);

//查询每个部门中职位(去重)
SELECT DEPTNO,GROUP_CONCAT(DISTINCT POSITION)
FROM EMP_ZHANG
GROUP BY DEPTNO;

//查询每个部门薪水(排序)
SELECT DEPTNO,GROUP_CONCAT(SALARY ORDER BY SALARY ASC)
FROM EMP_ZHANG
GROUP BY DEPTNO;

五.子查询(高级查询)
子查询:一条SQL语句中嵌套select查询语句

非关联子查询:嵌套的子查询是独立语句,不依赖主查询
1)查询最高薪水是谁
分布:
//查询最高薪水
SELECT MAX(SALARY) FROM EMP_ZHANG;
//根据最高薪水找人
SELECT ENAME,SALARY
FROM EMP_ZHANG
WHERE SALARY=最高薪水;
//合并
SELECT ENAME,SALARY
FROM EMP_ZHANG
WHERE SALARY=(SELECT MAX(SALARY) FROM EMP_ZHANG);

非关联子查询的执行过程:[重要]
先执行嵌套子查询(独立)->返回子查询结果作为主查询条件->再执行主查询

ps:
非关联子查询中,可以单独执行,并只执行一次.

2)查询薪水最低的是谁
SELECT EMPNO,SALARY
FROM EMP_ZHANG
WHERE SALARY=(SELECT MIN(SALARY) FROM EMP_ZHANG);

3)查询谁的薪水比'张无忌'高
SELECT EMPNO,ENAME,SALARY
FROM EMP_ZHANG
WHERE SALARY>(SELECT SALARY FROM EMP_ZHANG WHERE ENAME='张无忌');

4)查询'研发部'有哪些职位
SELECT POSITION 
FROM EMP_ZHANG 
WHERE DEPTNO=(SELECT DEPTNO FROM DEPT_ZHANG WHERE DNAME='研发部');

5)查询谁的薪水比'张无忌'高,如果有多个'张无忌'
INSERT INTO EMP_ZHANG
VALUES(1021,'张无忌','Clerk',8000,600,now(),1013,null);

//要求大于两个'张无忌'薪水
SELECT ENAME,SALARY
FROM EMP_ZHANG
WHERE SALARY>ALL(
SELECT SALARY FROM EMP_ZHANG WHERE ENAME='张无忌'
);//嵌套子查询返回多值时不能直接用大于号比较
//满足大于最大薪水'张无忌'
SELECT ENAME,SALARY
FROM EMP_ZHANG
WHERE SALARY>(
SELECT MAX(SALARY) FROM EMP_ZHANG WHERE ENAME='张无忌'
);

//查询哪些人的薪水比'张无忌'高,如果有多个'张无忌'
//满足任意一个'张无忌'薪水
SELECT ENAME,SALARY
FROM EMP_ZHANG
WHERE SALARY>ANY(
SELECT SALARY FROM EMP_ZHANG WHERE ENAME='张无忌'
);
//满足大于最小薪水的'张无忌'
SELECT ENAME,SALARY
FROM EMP_ZHANG
WHERE SALARY>(
SELECT MIN(SALARY) FROM EMP_ZHANG WHERE ENAME='张无忌'
);

PS:
比较符选择,由子查询返回结果决定的
单值:>	=	<
多值:>ALL	>ANY	=ANY	IN

7)查询谁和'郭靖'同部门,列出除了'郭靖'之外的员工姓名(单值)
SELECT ENAME,DEPTNO
FROM EMP_ZHANG
WHERE DEPTNO=(SELECT DEPTNO FROM EMP_ZHANG WHERE ENAME='郭靖') AND ENAME!='郭靖';

8)查询谁和'郭靖'同部门,列出除了'郭靖'之外的员工姓名(多值)
SELECT ENAME,DEPTNO
FROM EMP_ZHANG
WHERE DEPTNO=ANY(SELECT DEPTNO FROM EMP_ZHANG WHERE ENAME='郭靖') AND ENAME!='郭靖';
或者
SELECT ENAME,DEPTNO
FROM EMP_ZHANG
WHERE DEPTNO IN(SELECT DEPTNO FROM EMP_ZHANG WHERE ENAME='郭靖') AND ENAME!='郭靖';

PS:
IN等价于=ANY,两者可以互换

9)查询谁是'张三丰'的下属
SELECT EMPNO,ENAME,LEADER
FROM EMP_ZHANG
WHERE LEADER=(SELECT EMPNO FROM EMP_ZHANG WHERE ENAME='张三丰');

10)查询每个部门拿最高薪水是谁
//查询每个部门的最高薪水
SELECT DEPTNO,MAX(SALARY)
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO;//多值多列的情况

+--------+-------------+
| DEPTNO | MAX(SALARY) |
+--------+-------------+
|     10 |    99999.99 |
|     20 |     6000.00 |
|     30 |     8000.00 |
|     40 |    50000.00 |
+--------+-------------+
//根据部门号,薪水找人
SELECT ENAME,DEPTNO,SALARY
FROM EMP_ZHANG
WHERE (DEPTNO,SALARY)=ANY(
	SELECT DEPTNO,MAX(SALARY)
	FROM EMP_ZHANG
	WHERE DEPTNO IS NOT NULL
	GROUP BY DEPTNO
);//要求部门号等于部门号,薪水等于最大薪水,两者比较规则相同(=)

+--------+--------+----------+
| ENAME  | DEPTNO | SALARY   |
+--------+--------+----------+
| 张三丰 |     10 | 99999.99 |
| 黄蓉   |     20 |  6000.00 |
| 乔峰   |     30 |  8000.00 |
| 孙悟空 |     40 | 50000.00 |
+--------+--------+----------+

11)查询哪个部门的人数比30号部门人数多
SELECT DEPTNO,COUNT(*)
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
HAVING COUNT(*)>(
	SELECT COUNT(*)
	FROM EMP_ZHANG
	WHERE DEPTNO=30
);

12)查询哪个部门的平均薪水比20号部门的平均薪水高,要求没有部门的不算在内
SELECT DEPTNO,AVG(IFNULL(SALARY,0))
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
HAVING AVG(IFNULL(SALARY,0))>(SELECT AVG(IFNULL(SALARY,0))
FROM EMP_ZHANG
WHERE DEPTNO=20);
//20号部门的平均薪水
SELECT AVG(IFNULL(SALARY,0))
FROM EMP_ZHANG
WHERE DEPTNO=20;

13)查询员工所在部门的平均薪水＞5000的员工姓名和薪水*****************
//查询平均薪水大于5000的部门号和平均薪水
SELECT DEPTNO
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
HAVING AVG(IFNULL(SALARY,0))>5000;//多值

//根据部门找员工
SELECT ENAME,SALARY,DEPTNO
FROM EMP_ZHANG
WHERE DEPTNO=ANY(
SELECT DEPTNO
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
HAVING AVG(IFNULL(SALARY,0))>5000
);//=ANY等价于IN



14)查询哪些员工的薪水是本部门的平均薪水
SELECT ENAME,SALARY
FROM EMP_ZHANG
WHERE (DEPTNO,SALARY)=ANY(
SELECT DEPTNO, AVG(IFNULL(SALARY,0))
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
);//两者比较规则相同

//部门的平均薪水
SELECT DEPTNO, AVG(IFNULL(SALARY,0))
FROM EMP_ZHANG
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO;

15)查询哪些员工的薪水比本部门的平均薪水低
//分析
要求部门号等于部门号(=),薪水小于本部门平均薪水(<),
两者的比较规则不相同,非关联子查询不能实现

PS:非关联子查询
a.清楚非关联子查询的执行过程
b.比较符的选择(单值,多值)
c.多值多列的情况(比较规则相同)


关联子查询:嵌套的子查询不是独立语句,依赖主查询









