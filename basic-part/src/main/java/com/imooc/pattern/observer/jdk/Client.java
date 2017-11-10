package com.imooc.pattern.observer.jdk;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.jdk
 * @description: 测试类
 * @date 2017/11/10 20:54
 */
public class Client {
    public static void main(String[] args) {
        //创建天气作为一个目标（被观察者）
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
        ConcreteObserver girl = new ConcreteObserver();
        girl.setObserverName("女朋友");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("老妈");

        //注册观察者
        subject.addObserver(girl);
        subject.addObserver(mum);

        //目标更新天气情况
        subject.setContent("天气晴，气温28度");
    }
}
