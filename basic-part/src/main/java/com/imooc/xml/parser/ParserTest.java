package com.imooc.xml.parser;

import com.imooc.xml.ch03.SAXParserHandler;
import com.imooc.xml.entity.Book;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xml.parser
 * @description: TODO
 * @date 2017/11/11 17:00
 */
public class ParserTest {
    /**
     * DOM解析方式
     */
    public void domXmlParser() {
        ArrayList<Book> bookLists = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("xml/books.xml");
            NodeList bookList = document.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node book = bookList.item(i);
                Book bookEntity = new Book();
                NamedNodeMap attrs = book.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    if (attr.getNodeName().equals("id")) {
                        bookEntity.setId(attr.getNodeValue());
                    }
                }
                NodeList childNodes = book.getChildNodes();
                for (int k = 0; k < childNodes.getLength(); k++) {
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        String name = childNodes.item(k).getNodeName();
                        String value = childNodes.item(k).getFirstChild().getNodeValue();
                        if (name.equals("name")) {
                            bookEntity.setName(value);
                        } else if (name.equals("author")) {
                            bookEntity.setAuthor(value);
                        } else if (name.equals("year")) {
                            bookEntity.setYear(value);
                        } else if (name.equals("price")) {
                            bookEntity.setPrice(value);
                        } else if (name.equals("language")) {
                            bookEntity.setLanguage(value);
                        }
                    }
                }
                bookLists.add(bookEntity);
                bookEntity = null;
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * SAX解析方式
     */
    public void saxXmlParser() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler();
            parser.parse("xml/books.xml", handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JDOM解析方式
     */
    public void jdomXmlParser() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream in = null;
        try {
            in = new FileInputStream("xml/books.xml");
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            org.jdom2.Document document = saxBuilder.build(isr);
            org.jdom2.Element rootElement = document.getRootElement();
            List<Element> bookList = rootElement.getChildren();
            for (org.jdom2.Element book : bookList) {
                Book bookEntity = new Book();
                List<Attribute> attrList = book.getAttributes();
                for (Attribute attr : attrList) {
                    String attrName = attr.getName();
                    String attrValue = attr.getValue();
                    if (attrName.equals("id")) {
                        bookEntity.setId(attrValue);
                    }
                }
                List<org.jdom2.Element> bookChilds = book.getChildren();
                for (org.jdom2.Element child : bookChilds) {
                    if (child.getName().equals("name")) {
                        bookEntity.setName(child.getValue());
                    } else if (child.getName().equals("author")) {
                        bookEntity.setAuthor(child.getValue());
                    } else if (child.getName().equals("year")) {
                        bookEntity.setYear(child.getValue());
                    } else if (child.getName().equals("price")) {
                        bookEntity.setPrice(child.getValue());
                    } else if (child.getName().equals("language")) {
                        bookEntity.setLanguage(child.getValue());
                    }
                }
                booksList.add(bookEntity);
                bookEntity = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * DOM4J解析方式
     */
    public void dom4jXmlParser() {
        ArrayList<Book> booksList = new ArrayList<Book>();
        SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document document = reader.read(new File("xml/books.xml"));
            org.dom4j.Element bookStore = document.getRootElement();
            List<org.dom4j.Element> bookEles = bookStore.elements();
            for (org.dom4j.Element book : bookEles) {
                Book bookEntity = new Book();
                List<org.dom4j.Attribute> bookAttrs = book.attributes();
                for (org.dom4j.Attribute attr : bookAttrs) {
                    if (attr.getName().equals("id")) {
                        bookEntity.setId(attr.getValue());
                    }
                }
                List<org.dom4j.Element> bookss = book.elements();
                for (org.dom4j.Element bookChild : bookss) {
                    String name = bookChild.getName();
                    String value = bookChild.getStringValue();
                    if (name.equals("name")) {
                        bookEntity.setName(value);
                    } else if (name.equals("author")) {
                        bookEntity.setAuthor(value);
                    } else if (name.equals("year")) {
                        bookEntity.setYear(value);
                    } else if (name.equals("price")) {
                        bookEntity.setPrice(value);
                    } else if (name.equals("language")) {
                        bookEntity.setLanguage(value);
                    }
                }
                booksList.add(bookEntity);
                bookEntity = null;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("性能测试:");
        //测试DOM的性能:
        long start = System.currentTimeMillis();
        ParserTest test = new ParserTest();
        test.domXmlParser();
        System.out.println("DOM:" + (System.currentTimeMillis() - start));
        //测试SAX的性能:
        start = System.currentTimeMillis();
        test.saxXmlParser();
        System.out.println("SAX:" + (System.currentTimeMillis() - start));
        //测试JDOM的性能:
        start = System.currentTimeMillis();
        test.jdomXmlParser();
        System.out.println("JDOM:" + (System.currentTimeMillis() - start));
        //测试DOM4J的性能:
        start = System.currentTimeMillis();
        test.dom4jXmlParser();
        System.out.println("DOM4J:" + (System.currentTimeMillis() - start));
    }
}
