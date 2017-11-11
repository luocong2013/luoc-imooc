package com.imooc.pattern.proxy.ch05;

import java.lang.reflect.Method;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch05
 * @description: TODO
 * @date 2017/11/11 14:46
 */
public class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        try {
            long starttime = System.currentTimeMillis();
            System.out.println("汽车开始行驶....");
            m.invoke(target);
            long endtime = System.currentTimeMillis();
            System.out.println("汽车结束行驶....  汽车行驶时间："
                    + (endtime - starttime) + "毫秒！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
