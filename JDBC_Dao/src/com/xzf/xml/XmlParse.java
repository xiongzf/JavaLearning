package com.xzf.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XmlParse {
    public static void main(String[] args) {
        try {
            //1、创建 sax 解析对象
            SAXReader reader = new SAXReader();
            //2、制定解析的 xml 源
            Document document = reader.read(new File("src/com/xzf/xml/test.xml"));
            //3、得到元素
            Element rootE = document.getRootElement();
            //获取根元素下的所有子元素
            List<Element> elements = rootE.elements();

            for (Element e : elements) {
                String name = e.element("name").getText();
                String age = e.element("age").getText();
                String address = e.element("address").getText();
                System.out.println("name = " + name + " age = " + age + " address = " + address);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
