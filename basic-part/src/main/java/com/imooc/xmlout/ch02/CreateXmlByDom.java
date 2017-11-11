package com.imooc.xmlout.ch02;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xmlout.ch02
 * @description: TODO
 * @date 2017/11/11 17:04
 */
public class CreateXmlByDom {
    public DocumentBuilder getDocumentBuilder() {
        // 创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 创建DocumentBuilder对象
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }

    /**
     * 生成XML
     */
    public void createXML() {
        DocumentBuilder db = getDocumentBuilder();
        Document document = db.newDocument();
        document.setXmlStandalone(true);
        Element bookStore = document.createElement("bookStore");
        // 向bookstore根节点中添加子节点book
        Element book = document.createElement("book");
        Element name = document.createElement("name");
        name.setTextContent("小王子");
        Element author = document.createElement("author");
        author.setTextContent("乔治马丁");
        Element year = document.createElement("year");
        year.setTextContent("2016");
        Element price = document.createElement("price");
        price.setTextContent("16.7");

        book.appendChild(name);
        book.appendChild(author);
        book.appendChild(year);
        book.appendChild(price);
        book.setAttribute("id", "1");

        Element book2 = document.createElement("book");
        Element name2 = document.createElement("name");
        name2.setTextContent("数学模型");
        Element price2 = document.createElement("price");
        price2.setTextContent("34.8");

        book2.appendChild(name2);
        book2.appendChild(price2);
        book2.setAttribute("id", "2");

        // 将book节点添加到bookstore根节点中
        bookStore.appendChild(book);
        // 将book2节点添加到bookstore根节点中
        bookStore.appendChild(book2);
        // 将bookstore节点（已经包含了book）添加到dom树中
        document.appendChild(bookStore);
        //创建TransformerFactory对象
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            //创建Transformer对象
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.transform(new DOMSource(document), new StreamResult(new File("xml/books2.xml")));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateXmlByDom createXmlByDom = new CreateXmlByDom();
        createXmlByDom.createXML();
    }
}
