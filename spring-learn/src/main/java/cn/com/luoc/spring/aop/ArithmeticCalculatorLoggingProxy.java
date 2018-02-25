package cn.com.luoc.spring.aop;

import java.lang.reflect.Proxy;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/2/12 15:12
 */
public class ArithmeticCalculatorLoggingProxy {

    /**
     * 这个就是我们要代理的真实对象
     */
    private Object target;

    public ArithmeticCalculatorLoggingProxy(Object target) {
        this.target = target;
    }

    /**
     * 返回代理对象
     *
     * @return
     */
    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;
        Class<?> clazz = this.target.getClass();
        ClassLoader loader = clazz.getClassLoader();
        Class[] interfaces = clazz.getInterfaces();
        LoggingHandler h = new LoggingHandler(this.target);

        /**
         * loader: 代理对象使用的类加载器。
         * interfaces: 指定代理对象的类型. 即代理代理对象中可以有哪些方法.
         * h: 当具体调用代理对象的方法时, 应该如何进行响应, 实际上就是调用 InvocationHandler 的 invoke 方法
         */
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
        return proxy;
    }
}
