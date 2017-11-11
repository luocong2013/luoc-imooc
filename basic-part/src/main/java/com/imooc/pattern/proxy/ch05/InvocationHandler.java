package com.imooc.pattern.proxy.ch05;

import java.lang.reflect.Method;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch05
 * @description: TODO
 * @date 2017/11/11 14:45
 */
public interface InvocationHandler {
    void invoke(Object o, Method m);
}
