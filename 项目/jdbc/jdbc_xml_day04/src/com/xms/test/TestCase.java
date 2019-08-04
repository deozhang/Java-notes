package com.xms.test;

import com.xms.entity.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import javax.print.Doc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TestCase {
    @Test
    public void testRead(){
        //读XML
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("src/com/xms/xml/StudentList.xml"));
            //获取根元素
            Element root = document.getRootElement();
            //获取根元素下全部子元素
            List<Element> elements = root.elements();
            //集合
            List<Student> students = new ArrayList<Student>();
            //遍历集合取子元素
            for (Element element :
                    elements) {
                //属性id
                int id = Integer.parseInt(element.attribute("id").getValue());
                //文本内容 name/age/money
                String name = element.elementText("name");
                int age = Integer.parseInt(element.elementText("age"));
                int money = Integer.parseInt(element.elementText("money"));
                //对象
                Student student = new Student(id,name,age,money);
                //对象添加到集合
                students.add(student);
            }
            //测试
            for (Student student :
                    students) {
                System.out.println(student.getId()+","+student.getName()+","+student.getAge()+","+student.getMoney());
            }

//            String elementText(String name);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testWrite(){
        //写入XML
        //构造数据
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1001,"deo",18,1000));
        students.add(new Student(1002,"sunny",19,1200));
        students.add(new Student(1003,"didi",17,1040));
        //创建并返回Document对象
        Document document = DocumentHelper.createDocument();
        //添加根元素
        Element root = document.addElement("stuList");
        //根元素下添加子元素
        //遍历集合数据
        for (Student student :
                students) {
            Element element = root.addElement("stu");
            //添加属性
            element.addAttribute("stuId",student.getId()+"");
            //添加文本
            element.addElement("stuName").addText(student.getName());
            element.addElement("stuAge").addText(student.getAge()+"");
            element.addElement("stuMoney").addText(student.getMoney()+"");
        }
        XMLWriter writer = new XMLWriter();
        try {
            //输出
            writer.setOutputStream(new FileOutputStream("src/com/xms/xml/StuList.xml"));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
