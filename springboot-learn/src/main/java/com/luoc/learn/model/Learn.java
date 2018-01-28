package com.luoc.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 11:47
 */
@Entity
public class Learn {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "这个字段必传")
    @Column(name = "cupsize", nullable = false, length = 32)
    private String cupSize;

    @Min(value = 18, message = "未满18岁禁止注册")
    @Column(name = "age", nullable = false, length = 11)
    private Integer age;

    //@Max()
    //@Length()
    @NotNull(message = "金额必传")
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Learn{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
