package com.imooc.pattern.observer.diff;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.diff
 * @description: 区别对待观察者模式
 * @date 2017/11/10 20:44
 */
public abstract class WeatherSubject {
    /**
     * 用来保存注册的观察者对象
     */
    public List<Observer> observers = new ArrayList<>();

    /**
     * 把订阅天气的人/观察者添加到订阅者列表中
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除集合中指定的订阅天气的人
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    protected abstract void notifyObservers();
}
