package com.luoc.learn.service;

import com.luoc.learn.dao.LearnRepository;
import com.luoc.learn.enums.ResultEnum;
import com.luoc.learn.exception.LearnException;
import com.luoc.learn.model.Learn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 15:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LearnService {
    @Autowired
    private LearnRepository learnRepository;

    public void insertTwo() {
        Learn learnA = new Learn();
        learnA.setCupSize("Q");
        learnA.setAge(26);
        learnRepository.save(learnA);
        int a = 1 / 0;
        Learn learnB = new Learn();
        learnB.setCupSize("P");
        learnB.setAge(19);
        learnRepository.save(learnB);
    }

    public void getAge(Integer id) {
        Optional<Learn> optional = learnRepository.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        Integer age = optional.get().getAge();
        if (age < 10) {
            throw new LearnException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new LearnException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Id查询一条信息
     *
     * @param id
     * @return
     */
    public Learn findOne(Integer id) {
        Optional<Learn> optional = learnRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }
}
