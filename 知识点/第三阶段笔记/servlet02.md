# Servlet 02

## 1.http(hypertext transfer protocol)协议

超文本传输协议,是一种应用层协议,定义了浏览器与Web服务器的通讯过程以及数据包格式

### 通讯过程

1. 浏览器与服务器建立连接
2. 浏览器打包,发送请求
3. 服务器打包,发送响应
4. 断开连接

* 特点:一次请求,一次连接,一次响应
* 优点:效率高,可以使用有线的连接资源为更多的用户服务

### 数据包格式

#### 请求数据包

##### 第一部分:请求行

* 请求类型:get/post
* 请求资源路径:/servlet01/sayHello...
* 协议类型以及版本号

##### 第二部分:若干消息头

由浏览器按照w3c的规范自动生成的键值对,具有特定含义,比如user-agent定义了浏览器相关信息

##### 第三部分:实体内容

如果是get请求:此处是空
如果是post请求:参数名=参数值&...

#### 响应数据包

##### 第一部分:响应行

* 协议类型以及版本号:http/1.1
* 响应状态码

##### 第二部分:若干消息头

由服务器根据w3c规范生成的键值对,具有特定含义,也可以通过编程方式设置响应消息头的值,比如```content-type```,指定服务器返回的数据类型

##### 第三部分:实体内容

response中缓存的数据

## 2.get与post区别

### 哪些是get请求

* 在浏览器地址栏输入地址访问应用
* 点击链接```<a href=""></a>```
* form表单默认提交方式

### 哪些是post请求

* 将form表单提交方式改成post```<form method="post">```

### 区别

* get请求提交的数据量有限制,大约是2k-8k,为了兼容所有的浏览器,最好不要超过2k,而post理论上没有大小的限制
* post相对于get更安全,post也不是绝对性的安全,对于敏感的数据,建议加密

## 3.功能

### 添加管理员

```sql
create table admin(
    id int primary key auto_increment,
    username varchar(30),
    password varchar(30),
    realname varchar(30)
);
```

### 查询管理员

将admin表中的记录以table的形式展示到页面上
<localhost:8080/servlet02/list>

* 定义ListAdminServlet
* 使用jdbc技术查询admin表记录
* 使用out.print动态拼接表格

### 修改管理员

#### 1. 回显数据 ```load?id=3```

定义```LoadAdminServlet```处理该请求

* 获取参数id
* 使用jdbc技术查询admin表中对应的记录
* 使用out.print()将查询出的字段值拼接到form表单中

```Java
out.print("<form action='update'></form>");
out.print("<input name="username" value="jack">")
```

#### 更新数据

定义UpdateAdminServlet处理update请求

* 获取表单参数(id/username/password/realname)
* 使用jdbc技术更新admin表记录

```Java
update admin set username=?,password=?,
realname=? where id=?
```

* 重定向到列表界面

## 4.重定向

浏览器向服务器发送请求,服务器返回一个302的状态码以及location的消息头,当浏览器接收到302的状态码后,会立即向location的地址发送一个新的请求

### 如何重定向

```java
//url:重定向目的地
response.sendRedirect(String url);
```

注意:

1. 重定向之前,不能调用```out.close()```或者```out.flush()```
2. 重定向之前,会清空response中的缓存的数据

重定向特点:

1. 重定向的地址是任意的,可以跨应用,也可以跨服务
2. 重定向之后,浏览器地址栏的地址会发生改变

```java
//查询数据
Connection con = null;

try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd?characterEncoding=UTF-8", "root","12345678");
    String sql = "select * from admin";
    PreparedStatement ps = con.prepareStatement(sql);
} catch (Exception e) {
    e.printStackTrace();
}finally {
    if(con!=null) {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
