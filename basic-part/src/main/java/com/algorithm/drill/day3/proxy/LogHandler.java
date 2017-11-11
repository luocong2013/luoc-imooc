package com.algorithm.drill.day3.proxy;
/**
 * 导入InvocationHandler，该接口是代理实例的调用处理程序实现的接口。每个代理实例都具有
 * 一个关联的调用处理程序。对代理实例调用方法时，将对方法调用进行编码并将其指派到它的
 * 调用处理程序的invoke()方法。
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 处理类（切面(Aspect)）
 *
 * @author Luo
 */
public class LogHandler implements InvocationHandler {

    private Object object;

    public LogHandler() {
    }

    public LogHandler(Object object) {
        this.object = object;
    }

    /**
     * 实现接口InvocationHandler中的方法，在代理实例上处理方法调用并返回结果，在与方法关联的代理
     * 实例上调用方法时，将在调用处理程序上调用此方法。
     * 参数proxy：在其上调用方法的代理实例。
     * 参数method：对应于在代理实例上调用的接口方法的Method实例。Method对象的声明类将是在其中声明
     * 方法的接口，该接口可以是代理类赖以继承方法的代理接口的超接口。
     * 参数args：包含传入代理实例上方法调用的参数值的对象数组，如果接口方法不使用参数，则为null。
     * 基本类型的参数被包装在适当基本包装器类（如java.lang.Integer或java.lang.Boolean）的实例中。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("invoke()方法开始执行……");
        method.invoke(object, args);
        System.out.println("invoke()方法执行完毕……");
        return null;
    }

}
