# CSS

## CSS的使用

* 行内式()

  样式定义在html元素中,只对当前元素有效

  写法:

  1. 给元素添加style属性

  2. style属性直接写样式声明.

     <p style="样式:样式值;样式:样式值;"></p>

* 内部式(内嵌式)

  定义在<head>的<style>内,仅对当前页面有效

  写法:

  1.<head>中添加<head>

  2.<head>中写CSS语法

  <head>
      <div{
            color:red;
            }
  </head>

  div{}中的div是选择器



* 外部式(推荐)

  定义在.css文件中,此文件只包含样式声明规则

  1. @charset "utf-8"

  2. 引入到html页面<head>中

     <link type="text/css" href="file path" rel="stylesheet"/>

     rel:表示被链接的文件是一个样式表

  3. 样式文件中写样式规则

     

## css选择器

选择器是用来选中指定的节点(标签,标记,元素)

1)元素选择器	元素名{}		

2)类选择器	.类名{}

自定义的选择器,通常用于将页面的不同节点设置同一种样式

3)id选择器	#id名{}

同一个页面id是唯一的

4)交集选择器
要求同时满足,选择器和选择器之间不能有任何符号.

5)并集选择器
将多个选择器用逗号隔开,实现相同的样式作用于多个元素.

6)派生选择器:用于选择子元素
后代选择器:全部的后代元素    空格
子元素选择器:找儿子元素    >
下一个弟弟选择器:找同级元素(相邻选择器)    +

7)伪类选择器
用于设置同一个元素在不同状态下的样式
:link    未被访问的样式
:visited    已被访问的样式
:hover    鼠标悬停的样式
:active    鼠标按下的样式

爱恨原则:LoVe HAte

:focus    获取焦点样式

ps:元素,类,id选择器是基本选择器

优先级高低:
选择器:id>类>元素
引用方式:行内式>内部式>外部式

权重等级:
1)!important加载样式值后,权重值为10000
(提升优先级,一般不让用)
2)行内式(内联样式),权重值为1000
3)id选择器,权重值为0100
4)类,伪类和属性选择器,权重值为0010
5)元素选择器,权重值为0001
6)通用选择器(*),子选择器(>),相邻选择器(+),权重值为0000
7)继承的样式没有权重(子元素有自己的样式,听从自己样式显示,否则继承父元素样式)
8)权重值一样,后来者居上(就近原则)

样式冲突的比较规则:
1)先看是否选中,若一个选中一个没有选中,听选中的
2)若都选中,比权重值,听权重大的
3)若都没有选中,先比远近,听距离近的










