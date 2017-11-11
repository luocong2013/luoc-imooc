package com.algorithm.drill.day6;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Java爬虫爬取网页实现代码
 *
 * @author Luo
 */
public class Robot {
    private static Pattern pattern = Pattern.compile("^[a-zA-Z]+://[^\\s]*");
    /**
     * robot url
     */
    private List<String> urlList = null;
    /**
     * cache url
     */
    private Queue<String> urlQueue = null;
    /**
     * define Host
     */
    public final static String HOST = "www.cuit.edu.cn";

    public Robot() {
        super();
        setUrlList(new LinkedList<>());
        setUrlQueue(new LinkedList<>());
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public Queue<String> getUrlQueue() {
        return urlQueue;
    }

    public void setUrlQueue(Queue<String> urlQueue) {
        this.urlQueue = urlQueue;
    }

    private boolean isURL(String url) {
        try {

            Matcher matcher = pattern.matcher(url);
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isHost(String url) {
        return url.contains(HOST);
    }

    public void traverse(String seed) {
        for (this.getUrlQueue().add(seed); !this.getUrlQueue().isEmpty(); ) {
            boolean flag = true;
            Document document = null;
            try {
                document = Jsoup.connect(seed).timeout(5000).ignoreContentType(true).get();
            } catch (Exception e) {
                e.printStackTrace();
                flag = false;
            }
            if (flag) {
                Elements elements = document.select("a[href]");
                for (Element element : elements) {
                    String s = element.attr("abs:href");
                    if (isURL(s) && s.contains(HOST) && (!getUrlQueue().contains(s))
                            && (!getUrlList().contains(s))) {
                        this.getUrlQueue().add(s);
                    }
                }
            }
            seed = this.getUrlQueue().poll();
            this.getUrlList().add(seed);
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.traverse("http://www.cuit.edu.cn/");
        List<String> list = robot.getUrlList();
        for (String str : list) {
            System.out.println(str);
        }
    }

}
