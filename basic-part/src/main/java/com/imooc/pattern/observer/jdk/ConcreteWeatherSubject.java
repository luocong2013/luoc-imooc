package com.imooc.pattern.observer.jdk;

import java.util.Observable;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.jdk
 * @description: 天气目标的具体实现类
 * @date 2017/11/10 20:51
 */
public class ConcreteWeatherSubject extends Observable {
    /**
     * 天气内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        //通知所有的观察者
        //在用Java中的Observer模式的时候，下面这句不可少
        this.setChanged();
        //然后主动通知，下面是推的方式
        this.notifyObservers(content);
        //下面是拉的方式
//		this.notifyObservers();
    }
}
