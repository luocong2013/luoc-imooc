package com.luoc.learn.controller;

import com.luoc.learn.properties.LearnProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 16:47
 */
@RestController
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;

    @Autowired
    private LearnProperties learnProperties;

    @RequestMapping(value = "/say")
    public String say() {
        return learnProperties.getCupSize();
    }

    @RequestMapping(value = {"/hello", "/hi"})
    public String hello() {
        return "hello spring boot！" + cupSize + " age: " + age + " content: " + content;
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
