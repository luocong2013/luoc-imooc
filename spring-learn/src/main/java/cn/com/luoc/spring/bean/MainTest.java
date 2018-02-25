package cn.com.luoc.spring.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/2/12 14:51
 */
public class MainTest {

    public static void main(String[] args) {
        //1. 创建 IOC 容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-bean.xml");

        //2. 从 IOC 容器中获取 bean 实例
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");

        //3. 调用 bean 的方法
        helloWorld.hello();

        HelloWorld helloWorld2 = (HelloWorld) ctx.getBean("helloWorld");
        System.out.println(helloWorld == helloWorld2);

        //4. 关闭容器
        ctx.close();
    }
}
