package com.imooc.pattern.observer.diff;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.diff
 * @description: TODO
 * @date 2017/11/10 20:48
 */
public class ConcreteObserver implements Observer {
    /**
     * 观察者的名称
     */
    private String observerName;

    /**
     * 天气情况的内容
     */
    private String weatherContent;

    /**
     * 提醒的内容
     */
    private String remindThing;

    @Override
    public void update(WeatherSubject subject) {
        weatherContent = ((ConcreteWeatherSubject) subject).getWeatherContent();
        System.out.println(observerName + "收到了" + weatherContent + "，" + remindThing);
    }

    @Override
    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public String getObserverName() {
        return observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRemindThing() {
        return remindThing;
    }

    public void setRemindThing(String remindThing) {
        this.remindThing = remindThing;
    }
}
