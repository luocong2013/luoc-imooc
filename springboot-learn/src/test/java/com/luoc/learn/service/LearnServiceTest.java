package com.luoc.learn.service;

import com.luoc.learn.model.Learn;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/28 14:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnServiceTest {
    @Autowired
    private LearnService learnService;

    @Test
    public void findOne() {
        Learn learn = learnService.findOne(16);
        Assert.assertEquals(new Integer(18), learn.getAge());
    }
}