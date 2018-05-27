package com.luoc.learn.controller;

import com.luoc.learn.dao.LearnRepository;
import com.luoc.learn.model.Learn;
import com.luoc.learn.service.LearnService;
import com.luoc.learn.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 10:09
 */
@RestController
public class LearnController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LearnController.class);

    @Autowired
    private LearnRepository learnRepository;

    @Autowired
    private LearnService learnService;

    /**
     * 查找所有的
     *
     * @return
     */
    @GetMapping(value = "/learns")
    public JsonResult learns() {
        LOGGER.info("get learns");
        return JsonResult.buildSuccessJsonResult(learnRepository.findAll());
    }

    /**
     * 添加一条数据
     * (备注：应该使用@RequestBody获取整个bean的值)
     * 该方法不建议使用
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/learn")
    public JsonResult learnAdd(@RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age, @RequestParam("money") Double money) {
        Learn learn = new Learn();
        learn.setCupSize(cupSize);
        learn.setAge(age);
        learn.setMoney(money);
        return JsonResult.buildSuccessJsonResult(learnRepository.save(learn));
    }

    /**
     * 查找一条记录
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/learn/{id}")
    public JsonResult learnFindOne(@PathVariable("id") Integer id) {
        Optional<Learn> optional = learnRepository.findById(id);
        return JsonResult.buildSuccessJsonResult(optional.isPresent() ? optional.get() : "");
    }

    /**
     * 更新
     */
    @PutMapping(value = "/learn/{id}")
    public JsonResult learnUpdate(@PathVariable("id") Integer id,
                                  @RequestParam("cupSize") String cupSize,
                                  @RequestParam("age") Integer age,
                                  @RequestParam("money") Double money) {
        Learn learn = new Learn();
        learn.setId(id);
        learn.setCupSize(cupSize);
        learn.setAge(age);
        learn.setMoney(money);
        return JsonResult.buildSuccessJsonResult(learnRepository.save(learn));
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/learn/{id}")
    public JsonResult learnDelete(@PathVariable("id") Integer id) {
        learnRepository.deleteById(id);
        return JsonResult.buildSuccessJsonResult();
    }

    /**
     * 通过年龄查询
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/learn/age/{age}")
    public JsonResult learnListByAge(@PathVariable("age") Integer age) {
        return JsonResult.buildSuccessJsonResult(learnRepository.findByAge(age));
    }


    /**
     * 插入两条数据
     * 测试数据库事物
     */
    @PostMapping(value = "/learn/two")
    public JsonResult learnTwo() {
        learnService.insertTwo();
        return JsonResult.buildSuccessJsonResult();
    }

    /**
     * 添加一条数据
     * 通过 bean 形式
     *
     * @param learn
     * @return
     */
    @PostMapping(value = "/learnSave")
    public JsonResult learnSave(@Valid Learn learn, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.buildErrorJsonResult(bindingResult.getFieldError().getDefaultMessage());
        }
        return JsonResult.buildSuccessJsonResult(learnRepository.save(learn));
    }

    @GetMapping(value = "/learn/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) {
        learnService.getAge(id);
    }

}
