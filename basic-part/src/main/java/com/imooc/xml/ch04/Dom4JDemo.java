package com.imooc.xml.ch04;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xml.ch04
 * @description: TODO
 * @date 2017/11/11 16:58
 */
public class Dom4JDemo {
    public static void main(String[] args) {
        // 解析xml/books.xml文件
        // 创建SAXReader对象reader
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载xml/books.xml文件,获取docuemnt对象
            Document document = reader.read(new File("xml/books.xml"));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator<Element> it = bookStore.elementIterator();
            while (it.hasNext()) {
                System.out.println("=====开始遍历某一本书=====");
                Element book = it.next();
                // 获取book的属性名以及 属性值
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名：" + attr.getName() + "-->属性值："
                            + attr.getValue());
                }
                Iterator<Element> itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = itt.next();
                    System.out.println("节点名：" + bookChild.getName() + "-->节点值："
                            + bookChild.getStringValue());
                }
                System.out.println("=====结束遍历某一本书=====");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
