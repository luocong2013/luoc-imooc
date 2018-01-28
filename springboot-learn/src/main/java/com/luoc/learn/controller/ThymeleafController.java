package com.luoc.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 16:50
 */
@Controller
public class ThymeleafController {

    /**
     * 模板引擎
     * 需要使用 @Controller 注解, 则返回templates/index.* 页面
     * 使用 @RestController 则返回 json 数据
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/hotDeploy")
    public String hotDeploy(HttpServletRequest request) {
        request.setAttribute("say", "Hello HotDeploy");
        return "hot";
    }
}
