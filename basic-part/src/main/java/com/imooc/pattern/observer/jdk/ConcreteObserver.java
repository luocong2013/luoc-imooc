package com.imooc.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.jdk
 * @description: 具体的观察者对象
 * @date 2017/11/10 20:53
 */
public class ConcreteObserver implements Observer {
    /**
     * 观察者名称的变量
     */
    private String observerName;

    @Override
    public void update(Observable o, Object arg) {
        //第一种是推的方式
        System.out.println(observerName + "收到了消息，目标推送过来的是" + arg);

        //第二种是拉的方式
        System.out.println(observerName + "收到了消息，主动到目标对象种去拉，拉的内容是"
                + ((ConcreteWeatherSubject) o).getContent());
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }
}
