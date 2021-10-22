package com.shf.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
//        创建一个SaxReader输入流,去读取xml配置文件,生成Document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    @Test
    public void test2() throws DocumentException {
//        1. 读取books.xml文件
        SAXReader saxReader = new SAXReader();
//        2.通过Documents对象获取根元素
//        在juit测试中,相对路径时从模块名开始
        Document document = saxReader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);

//        3.通过根元素获取book标签对象
//        elements根据标签名查找子元素
        List<Element> books = rootElement.elements("book");
//        4.遍历,处理每个book标签转换为Book类
        for (Element book : books){
            System.out.println(book.asXML());

            Element nameElemet = book.element("name");
            Element priceElement = book.element("price");
            Element authorElement = book.element("author");
            String name = nameElemet.getText();
            String author = authorElement.getText();
            String price = priceElement.getText();
            System.out.println(name+price+author);
        }
    }
}
