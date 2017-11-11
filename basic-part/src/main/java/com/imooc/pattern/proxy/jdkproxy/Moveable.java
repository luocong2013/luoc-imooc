package com.imooc.pattern.proxy.jdkproxy;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.jdkproxy
 * @description: 开车接口
 * @date 2017/11/11 14:53
 */
public interface Moveable {
    /**
     * 开车
     */
    void move();

    /**
     * 停车
     *
     * @param name
     */
    void stop(String name);
}
