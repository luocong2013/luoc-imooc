package com.imooc.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.jdkproxy
 * @description: TODO
 * @date 2017/11/11 14:54
 */
public class TimeHandler implements InvocationHandler {
    /**
     * 这个就是我们要代理的真实对象
     */
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     * 参数：
     * proxy  被代理对象（我们所代理的那个真实的对象）
     * method  被代理对象的方法（我们所要调用真实对象的某个方法的Method对象）
     * agrs  方法的参数（调用真实对象某个方法时接受的参数）
     * <p>
     * 返回值：
     * Object  方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶……");
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(target, args);
        //在代理真实对象后我们也可以添加一些自己的操作
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶结束……汽车行驶时间：" + (endTime - startTime) + "ms");
        return null;
    }
}
