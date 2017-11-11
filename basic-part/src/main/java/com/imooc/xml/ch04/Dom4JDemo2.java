package com.imooc.xml.ch04;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xml.ch04
 * @description: TODO
 * @date 2017/11/11 16:59
 */
public class Dom4JDemo2 {

    public static void main(String[] args) {
        // 解析xml/books.xml文件
        // 创建SAXReader对象reader
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载xml/books.xml文件,获取docuemnt对象
            Document document = reader.read(new File("xml/books.xml"));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            // 得到根节点下的所有子节点
            List<Element> bookList = bookStore.elements();
            for (Element book : bookList) {
                System.out.println("=====开始遍历第" + (bookList.indexOf(book) + 1)
                        + "本书=====");
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名：" + attr.getName() + "-->属性值："
                            + attr.getValue());
                }
                List<Element> bookChilds = book.elements();
                for (Element child : bookChilds) {
                    System.out.println("节点名：" + child.getName() + "-->节点值："
                            + child.getText());
                }
                System.out.println("=====结束遍历第" + (bookList.indexOf(book) + 1)
                        + "本书=====");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
