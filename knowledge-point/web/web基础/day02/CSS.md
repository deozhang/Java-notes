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



ps:元素,类,id选择器是基本选择器









