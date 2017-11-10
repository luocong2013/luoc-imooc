package com.imooc.pattern.observer.common;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.common
 * @description: 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @date 2017/11/10 20:40
 */
public class ConcreteObserver implements Observer {
    /**
     * 观察者的状态
     */
    private String observerState;

    /**
     * 获取目标类的状态同步到观察者的状态中
     */
    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject) subject).getSubjectState();
    }
}
