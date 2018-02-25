package cn.com.luoc.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/2/12 15:10
 */
public class MainTest {
    public static void main(String[] args) {
        /**
         * jdk动态代理模式
         */
        /*ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
        arithmeticCalculator = new ArithmeticCalculatorLoggingProxy(arithmeticCalculator).getLoggingProxy();
        int result = arithmeticCalculator.add(11, 12);
		System.out.println("result:" + result);

		result = arithmeticCalculator.div(21, 3);
		System.out.println("result:" + result);*/

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");
        int result = arithmeticCalculator.add(11, 12);
        System.out.println("result:" + result);

        result = arithmeticCalculator.div(21, 3);
        System.out.println("result:" + result);
    }
}
