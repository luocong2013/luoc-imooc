package com.imooc.pattern.observer.weather;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.weather
 * @description: 测试类
 * @date 2017/11/10 21:00
 */
public class Client {
    public static void main(String[] args) {
        //1 创建目标
        ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
        //2 创建观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("女朋友");
        observerGirl.setRemingThing("是我们的第一次约会的日子，地点街心花园");

        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("老妈");
        observerMum.setRemingThing("是一个购物的好日子，明天去天虹扫货");
        //3 注册观察者
        weather.attach(observerGirl);
        weather.attach(observerMum);
        //4 目标发布天气
        weather.setWeatherContent("\n明天 天气晴朗，蓝天白云，气温28度");
    }
}
