package com.imooc.pattern.observer.common;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.observer.common
 * @description: 这是一个观察者接口，定义一个更新的接口给那些在目标
 * 发生改变的时候被通知的对象
 * @date 2017/11/10 20:35
 */
public interface Observer {
    /**
     * 更新接口
     *
     * @param subject 传入目标对象，方便获取相应的目标对象的状态
     */
    void update(Subject subject);
}
