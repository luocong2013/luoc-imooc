package com.imooc.xml.ch04;

import com.imooc.xml.entity.Book;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xml.ch04
 * @description: TODO
 * @date 2017/11/11 16:57
 */
public class JdomDemo {

    private static List<Book> booksList = new ArrayList<>();

    public static void main(String[] args) {
        // 进行对xml/books.xml文件的JDOM解析
        // 准备工作
        // 1.创建一个SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream in = null;
        try {
            // 2.创建一个输入流，将xml文件加载到输入流中
            in = new FileInputStream("xml/books.xml");
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            // 3.通过saxBuilder的build方法，将输入流加载到saxBuilder中
            Document document = saxBuilder.build(isr);
            // 4.通过document对象获取xml文件的根节点
            Element rootElement = document.getRootElement();
            // 5.获取根节点下的子节点的List集合
            List<Element> bookList = rootElement.getChildren();
            // 继续进行解析
            for (Element book : bookList) {
                Book bookEntity = new Book();
                System.out.println("======开始解析第" + (bookList.indexOf(book) + 1)
                        + "本书======");
                // 解析book的属性集合
                List<Attribute> attrList = book.getAttributes();
                /**
                 * 知道节点下属性名称时，获取节点值
                 */
                // book.getAttributeValue("id");
                /**
                 * 遍历attrList(针对不清楚book节点下属性的名字及数量)
                 */
                for (Attribute attr : attrList) {
                    // 获取属性名
                    String attrName = attr.getName();
                    // 获取属性值
                    String attrValue = attr.getValue();
                    System.out.println("属性名：" + attrName + "-->属性值："
                            + attrValue);
                    if (attrName.equals("id")) {
                        bookEntity.setId(attrValue);
                    }
                }
                // 对book节点的子节点的节点名以及节点值的遍历
                List<Element> bookChilds = book.getChildren();
                for (Element child : bookChilds) {
                    // 获取节点名
                    String childName = child.getName();
                    // 获取节点值
                    String childValue = child.getValue();
                    System.out.println("节点名：" + childName + "-->节点值："
                            + childValue);
                    if (childName.equals("name")) {
                        bookEntity.setName(childValue);
                    } else if (childName.equals("author")) {
                        bookEntity.setAuthor(childValue);
                    } else if (childName.equals("year")) {
                        bookEntity.setYear(childValue);
                    } else if (childName.equals("price")) {
                        bookEntity.setPrice(childValue);
                    } else if (childName.equals("language")) {
                        bookEntity.setLanguage(childValue);
                    }
                }
                System.out.println("======结束解析第" + (bookList.indexOf(book) + 1)
                        + "本书======");
                booksList.add(bookEntity);
                bookEntity = null;
                System.out.println(booksList.size());
                System.out.println(booksList.get(0).getId());
                System.out.println(booksList.get(0).getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
