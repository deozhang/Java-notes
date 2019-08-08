# servlet03

## 1.DAO(date access object)

封装了数据访问逻辑,调用者不需要了封装的细节,如此,当数据封装的细节发生改变时,不会影响调用者

* 优点:便于后期扩展以及维护

### 如何定义一个DAO

* 定义一个实体类,便于封装表记录的数据

* 定义一个DAO接口,在接口中添加与具体技术类型无关的抽象方法

```java
List<Admin> findAll() throws Exception;建议
ResultSet findAll() throws Exception;
List<Admin> findAll() throws SQLException;
```

* 定义DAO实现类,在实现类中使用具体的技术重写抽象方法

## 2.工厂设计模式

所谓设计模式指的是为了解决一类相同或者相似的问题而提出的一套解决方案,并为此命名
工厂设计模式目的在于返回一个符合接口要求的对象,工厂封装了对象创建的细节,当细节发生改变时,不会影响调用者

```java
Connection:DriverManager.getConnection(url);
```

* servlet容器如何处理请求资源路径

localhost:8080/servlet03/list
什么是请求资源路径
端口号之后的部分,即/servlet03/list
如何处理
容器根据应用名查找webapps目录下对应的文件夹,如果找到了该文件夹,容器会先认为访问的是servlet组件,根据/list与web.xml文件中的url-pattern进行匹配,若匹配成功,调用相应的servlet处理请求,若匹配失败,容器会认为访问的是静态资源文件,根据路径查找该文件,若找到,则返回该文件,否则返回404

<localhost:8080/>servlet03/add.html>

匹配规则:
a.精确匹配,完全匹配
以"/"开头,比如"list"
b.通配符匹配
以"/"开头,比如"/*""/abc/*"
*:任意长度的任意字符
c.后缀匹配
不能以"/"开头,以某个单词结尾
比如".do"".action"
