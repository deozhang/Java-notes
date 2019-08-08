# servlet04

## 知识点回顾

* servlet:数据访问逻辑(JDBC),页面表示逻辑(out.print),业务逻辑(Java)
* JDBC--->DAO

```text
好处:
1.提高了代码的复用率
2.降低了servlet与jdbc的代码耦合度,便于后期维护
```

* 工厂设计模式

```Java
servlet--->new Dao().findAll();
返回一个符合要求的对象
servlet-->Factory.method().findAll();
```

* 使用配置文件定义接口与实现类的对应关系

```Java
AdminDao=实现类的完整路径,从包名开始写
ConfigUtil--->封装根据key获取value值的方法
Factory--->调用ConfigUtil,获取实现类路径,再利用反射的技术创建DAO对象
```

* 容器处理请求资源路径 /appname/path

```text
1.先认为访问的是servlet组件,根据/path与url-pattern进行匹配,成功则调用响应的servlet
2.失败,容器会认为访问的某一个静态资源文件,根据路径查找文件,找到则返回,否则,返回404
```

```text
匹配规则:
a.精确匹配,完全匹配
以"/"开头,比如"list"
b.通配符匹配
以"/"开头,比如"/*""/abc/*"
*:任意长度的任意字符
c.后缀匹配
不能以"/"开头,以某个单词结尾
比如".do"".action"
```

---

1. 一个servlet如何处理多个请求资源路径

* 采用后缀匹配规则
* 在servlet中获取请求资源路径,再分析判断,一个分支处理一个请求

```Java
String:req.getRequestURL();
```