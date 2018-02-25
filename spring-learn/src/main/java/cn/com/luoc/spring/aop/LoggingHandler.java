package cn.com.luoc.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/2/12 15:20
 */
public class LoggingHandler implements InvocationHandler {

    /**
     * 这个就是我们要代理的真实对象
     */
    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    /**
     * 参数：
     * proxy  被代理对象（我们所代理的那个真实的对象）。 一般不使用该对象
     * method  被代理对象的方法（我们所要调用真实对象的某个方法的Method对象）
     * agrs  方法的参数（调用真实对象某个方法时接受的参数）
     * <p>
     * 返回值：
     * Object  方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        //打印日志
        System.out.println("[before] The method " + methodName + " begins with " + Arrays.asList(args));

        //调用目标方法
        Object result = null;
        try {
            //前置通知
            result = method.invoke(target, args);
            //返回通知
        } catch (NullPointerException e) {
            e.printStackTrace();
            //异常通知, 可以访问到方法出现的异常
        }

        //后置通知. 因为方法可以能会出异常, 所以访问不到方法的返回值

        //打印日志
        System.out.println("[after] The method ends with " + result);

        return result;
    }
}
