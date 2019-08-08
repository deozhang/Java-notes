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
