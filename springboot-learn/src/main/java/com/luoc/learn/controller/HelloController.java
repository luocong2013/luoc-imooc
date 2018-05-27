package com.luoc.learn.controller;

import com.luoc.learn.properties.LearnProperties;
import com.luoc.learn.properties.MyWebProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 16:47
 */
@RestController
public class HelloController {
    /**
     * 读取application配置文件中的数据 方式一
     */
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;

    /**
     * 读取application配置文件中的数据 方式二 (防止乱码统一编码格式)
     */
    @Autowired
    private Environment env;

    /** 读取application配置文件中的数据 方式三 */
    @Autowired
    private LearnProperties learnProperties;

    /**
     * 读取自定义配置文件数据
     */
    @Autowired
    private MyWebProperties myWebProperties;

    @RequestMapping(value = {"/hello", "/hi"})
    public String hello() {
        return "hello spring boot！" + cupSize + " age: " + age + " content: " + content;
    }

    @GetMapping(value = "/speak")
    public String speak() {
        return "speak: " + env.getProperty("content");
    }

    @RequestMapping(value = "/say")
    public String say() {
        return learnProperties.getCupSize();
    }

    @GetMapping(value = "/define")
    public String define() {
        return myWebProperties.getTitle() + " " + myWebProperties.getAuthor() + " " + myWebProperties.getVersion();
    }

    /**
     * http://127.0.0.1:8081/show/5
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Integer id) {
        return "id: " + id;
    }

    /**
     * http://127.0.0.1:8081/show1?id=200
     *
     * @param myId
     * @return
     */
    @RequestMapping(value = "/show1", method = RequestMethod.GET)
    public String show1(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id: " + myId;
    }
}
