package com.luoc.learn.dao;

import com.luoc.learn.model.Learn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 14:42
 */
public interface LearnRepository extends JpaRepository<Learn, Integer> {

    /**
     * 通过年龄查询
     *
     * @param age
     * @return
     */
    List<Learn> findByAge(Integer age);

}
