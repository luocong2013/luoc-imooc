package com.imooc.xml.ch03;

import com.imooc.xml.entity.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xml.ch03
 * @description: TODO
 * @date 2017/11/11 16:54
 */
public class SAXParserHandler extends DefaultHandler {

    int bookIndex = 0;
    String value = null;
    Book book = null;
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    /**
     * 用来遍历xml的开始标签
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        //调用DefaultHandler类的startElement方法
        super.startElement(uri, localName, qName, attributes);
        //开始解析book元素的属性
        if (qName.equals("book")) {
            bookIndex++;
            //创建一个Book对象
            book = new Book();
            System.out.println("==========开始遍历第" + bookIndex + "本书的内容==========");
            /**
             * 已知book元素下属性的名称，根据属性名称获取属性值
             */
//			String value = attributes.getValue("id");
//			System.out.println("book的属性值是：" + value);
            /**
             * 不知道book元素下属性的名称以及个数
             */
            int num = attributes.getLength();
            for (int i = 0; i < num; i++) {
                System.out.print("book元素的第" + (i + 1) + "个属性名是：" + attributes.getQName(i));
                System.out.println("-->属性值是：" + attributes.getValue(i));
                if (attributes.getQName(i).equals("id")) {
                    book.setId(attributes.getValue(i));
                }
            }
        } else if (!qName.equals("book") && !qName.equals("bookstore")) {
            System.out.print("节点名是：" + qName);
        }
    }

    /**
     * 用来遍历xml的结束标签
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        //判断是否针对一本书已经遍历结束
        if (qName.equals("book")) {
            books.add(book);
            book = null;
            System.out.println("==========结束遍历第" + bookIndex + "本书的内容==========");
        } else if (qName.equals("name")) {
            book.setName(value);
        } else if (qName.equals("author")) {
            book.setAuthor(value);
        } else if (qName.equals("year")) {
            book.setYear(value);
        } else if (qName.equals("price")) {
            book.setPrice(value);
        } else if (qName.equals("language")) {
            book.setLanguage(value);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println("-->节点值是：" + value);
        }
    }

    /**
     * 用来标识解析开始
     */
    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    /**
     * 用来标识解析结束
     */
    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.endDocument();
        System.out.println("SAX解析结束");
    }
}
