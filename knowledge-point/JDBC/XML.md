# XML
>XML：可拓展的标记语言
用途：XML独立于软件和硬件的信息传输工具，常用简化数据存储和共享。

XML处理指令：
处理指令用于只会解析引擎如何解析XML文档。
<?xml version="1.0" encodeing="utf-8"?>

ps:
1)<?开始，?>结束
2）xml表示处理指令名称
3）version表示版本
4）encoding表示编码

XML组成：
XML文档中包含XML元素，元素指的是从开始标签到结束标签的部分，元素可以包含其他元素、文本，元素也可以有属性，属性可以提供关于元素额外信息。

<dataSource>
    <property></property>
    <property></property>
</dateSource>

ps:
1)XML文档中只有一个根元素(不被其他元素包围的)
2)元素必须有开始和结束标签
3)严格区分大小写
4)属性值必须加引号
5)元素必须正确嵌套

XML解析方式(重点)
1)DOM解析
全程:Document Object Model即文档对象模型
DOM解析器在解析XML文档时，会把文档中全部元素按照出现的层次结构关系，解析成一个个对象节点。
优点：把XML文档在内存中形成一个树形结构，可以遍历和修改节点。
缺点：如果文档比较大，内存压力比较大，解析时间比较长。
2)SAX解析
全程：Simple APIs for XML即XML简单应用程序接口
相比于DOM解析，SAX是一种速度快，更为有效的解析方式。它逐行扫描文件，一边扫描一边解析，SAX可以在文档中任意时刻停止解析。
优点：可以立即开始、速度快、内存压力比较小
缺点：不能对节点修改。

3)JDOM解析
特点：
1)仅使用具体类，而不是用接口
2)API大量使用Collections类
4)DOM4j解析
特点：
1)DOM4j是要给开源的、基于Java库来解析XML文档
2)具有性能优异、灵活性好，功能强大和易用的特点。

操作：
1)都XML文档
//创建对象
SAXReader reader = new SAXReader();
//都文件
Document document = reader.read(new File(""));

//Document对象
文档树的根，可以为我们提供对文档数据的最初访问入口。
//获取根元素
Element root = document.getRootElement();

//Element对象
XML文档中元素，元素可以包含其他元素、属性、和问本内容。
//获取根元素下面的全部子元素
List<Element> element = root.elements();
//获取当前元素的指定名字的属性
Attribute attribute(String name);
//Attribute对象
//用于描述一个元素中属性信息
//获取当前属性的值
String getValue();
//获取元素的文本内容
String elementText(String name);

2)写入XML
//创建并返回Document对象
Document document = DocumentHelper.createDocument();
//向文档中添加根元素并返回此元素,此方法只调用一次
//通过Document对象提供的方法添加根元素
Element addElement(String name);
//向当前元素添加指定名字的子元素
Element addElement(String name);
//向当前元素中添加指定属性及属性值返回当前元素
Element addAttribute(String name,String value);
//向当前元素中添加指定的文本
Element addTest(String text);
//通过XMLWriter将文档输出生成XML文件
XMLWriter write = new XMLWriter();
writer.setOutputSteam(new FileOutputStream(""));
writer.write(document);
writer.close();

