package com.imooc.pattern.observer.common;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.common
 * @description: 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 * @date 2017/11/10 20:41
 */
public class ConcreteSubject extends Subject {
    /**
     * 目标对象的状态
     */
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObservers();
    }
}
