package com.imooc.xmlout.ch04;

import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.xmlout.ch04
 * @description: TODO
 * @date 2017/11/11 17:08
 */
public class CreateXmlByJDom {

    public void createXML() {
        // 1. 生成一个根节点
        Element rss = new Element("rss");
        // 2. 为节点添加属性
        rss.setAttribute("version", "2.0");
        // 3. 生成一个document对象
        Document document = new Document(rss);

        Element channel = new Element("channel");
        rss.addContent(channel);
        Element title = new Element("title");
        CDATA cdata = new CDATA("上海移动互联网产业促进中心正式揭牌");
        title.addContent(cdata);
        channel.addContent(title);

//		// 创建Format对象，这个方法是生成紧凑的xml格式，已经换过行了，但是没有缩进
//		Format format = Format.getCompactFormat();
//		// 设置换行以及编码
//		/**
//		 * 这句代码是实现xml中行的缩进的，里面的参数是空格，要想在xml文件的行中缩进1个空格，则在setIndent("")的参数里面传一个空格
//		 * ，就是在键盘上按一下空格键。想要缩进n个空格，就在参数里按n个空格
//		 */
//		format.setIndent("");
//		format.setEncoding("GBK");

        Format format = Format.getPrettyFormat();
        format.setEncoding("GBK");

        // 4. 创建XMLOutputter对象
        XMLOutputter outputter = new XMLOutputter(format);
        try {
            // 5.利用outputer将document对象转换成xml文档
            outputter.output(document, new FileOutputStream(new File(
                    "xml/rssxml.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CreateXmlByJDom().createXML();
    }
}
