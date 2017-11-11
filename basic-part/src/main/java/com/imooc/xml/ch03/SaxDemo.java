package com.imooc.xml.ch03;

import com.imooc.xml.entity.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xml.ch03
 * @description: TODO
 * @date 2017/11/11 16:53
 */
public class SaxDemo {
    public static void main(String[] args) {
        //获取一个SAXParserFactor实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            //通过factory获取SAXParser实例
            SAXParser parser = factory.newSAXParser();
            //创建SAXParserHandler对象
            SAXParserHandler handler = new SAXParserHandler();
            parser.parse("xml/books.xml", handler);
            System.out.println("~!~!~!共有" + handler.getBooks().size() + "本书");
            for (Book book : handler.getBooks()) {
                System.out.println(book.getId());
                System.out.println(book.getName());
                System.out.println(book.getAuthor());
                System.out.println(book.getYear());
                System.out.println(book.getPrice());
                System.out.println(book.getLanguage());
                System.out.println("=============================");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
