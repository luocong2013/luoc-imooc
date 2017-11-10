package com.imooc.pattern.observer.diff;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.diff
 * @description: 测试类
 * @date 2017/11/10 20:49
 */
public class Client {
    public static void main(String[] args) {
        //1 创建目标
        ConcreteWeatherSubject weatherSubject = new ConcreteWeatherSubject();
        //2 创建观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("女朋友");
        observerGirl.setRemindThing("下雨了，安静的待在家里吧");

        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("老妈");
        observerMum.setRemindThing("不管下雨还是下雪，我都不出门了");
        //3 注册观察者
        weatherSubject.attach(observerGirl);
        weatherSubject.attach(observerMum);
        //4 目标发布天气
        weatherSubject.setWeatherContent("下雨");
    }
}
