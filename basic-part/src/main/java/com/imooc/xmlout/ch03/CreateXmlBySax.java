package com.imooc.xmlout.ch03;

import com.imooc.xmlout.entity.Book;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xmlout.ch03
 * @description: TODO
 * @date 2017/11/11 17:05
 */
public class CreateXmlBySax {

    public List<Book> parseXML() {
        //获取一个SAXParserFactor实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParserHandler handler = null;
        try {
            //通过factory获取SAXParser实例
            SAXParser parser = factory.newSAXParser();
            //创建SAXParserHandler对象
            handler = new SAXParserHandler();
            parser.parse("xml/books.xml", handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handler.getBooks();
    }

    public void createXML() {
        List<Book> bookList = parseXML();
        //生成xml
        //1. 创建一个SAXTransformerFactory类的对象
        SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            //2. 通过SAXTransformerFactory对象创建一个TransformerHandler对象
            TransformerHandler handler = tff.newTransformerHandler();
            //3. 通过handler对象创建一个Transformer对象
            Transformer tr = handler.getTransformer();
            //4. 通过Transformer对象对生成的xml文件进行设置
            //设置xml的编码
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //设置xml的“是否换行”
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            //5. 创建一个Result对象
            File file = new File("xml/books3.xml");
            if (!file.exists()) {
                file.createNewFile();
            }
            //6. 创建Result对象，并且使其与handler关联
            Result result = new StreamResult(new FileOutputStream(file));
            handler.setResult(result);
            //7. 利用handler对象进行xml文件内容的编写
            //打开document
            handler.startDocument();
            AttributesImpl attr = new AttributesImpl();
            handler.startElement("", "", "bookStore", attr);
            for (Book book : bookList) {
                //创建book节点
                attr.clear();
                attr.addAttribute("", "", "id", "", book.getId());
                handler.startElement("", "", "book", attr);
                //创建name节点
                if (book.getName() != null && !book.getName().trim().equals("")) {
                    attr.clear();
                    handler.startElement("", "", "name", attr);
                    handler.characters(book.getName().toCharArray(), 0, book.getName().length());
                    handler.endElement("", "", "name");
                }
                //创建author节点
                if (book.getAuthor() != null && !book.getAuthor().trim().equals("")) {
                    attr.clear();
                    handler.startElement("", "", "author", attr);
                    handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
                    handler.endElement("", "", "author");
                }
                //创建year节点
                if (book.getYear() != null && !book.getYear().trim().equals("")) {
                    attr.clear();
                    handler.startElement("", "", "year", attr);
                    handler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
                    handler.endElement("", "", "year");
                }
                //创建price节点
                if (book.getPrice() != null && !book.getPrice().trim().equals("")) {
                    attr.clear();
                    handler.startElement("", "", "price", attr);
                    handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
                    handler.endElement("", "", "price");
                }
                //创建language节点
                if (book.getLanguage() != null && !book.getLanguage().trim().equals("")) {
                    attr.clear();
                    handler.startElement("", "", "language", attr);
                    handler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().length());
                    handler.endElement("", "", "language");
                }
                handler.endElement("", "", "book");
            }
            handler.endElement("", "", "bookStore");
            //关闭doucment
            handler.endDocument();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        CreateXmlBySax createXmlBySax = new CreateXmlBySax();
        createXmlBySax.createXML();
    }
}
