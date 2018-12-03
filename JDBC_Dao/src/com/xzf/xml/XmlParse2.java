package com.xzf.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XmlParse2 {
    public static void main(String[] args) {
        try {
            //1、创建 sax 解析对象
            SAXReader reader = new SAXReader();
            //2、制定解析的 xml 源
            Document document = reader.read(new File("src/com/xzf/xml/test.xml"));
            //3、得到元素
            Element rootE = document.getRootElement();

            Element nameE = (Element) rootE.selectSingleNode("//name");
            System.out.println(nameE.getText());

            List<Element> list = rootE.selectNodes("//name");
            for (Element e : list) {
                System.out.println(e.getText());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
