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
