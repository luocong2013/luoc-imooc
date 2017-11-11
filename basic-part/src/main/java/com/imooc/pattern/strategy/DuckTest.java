package com.imooc.pattern.strategy;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.strategy
 * @description: 测试类
 * @date 2017/11/11 15:13
 */
public class DuckTest {
    public static void main(String[] args) {
        System.out.println("测试鸭子程序");
        System.out.println("************************");
        Duck duck = null;
//		duck = new MallardDuck();
//		duck = new RedheadDuck();
//		duck = new RubberDuck();
//		duck = new BigYellow();
        duck = new SpaceDuck();

        duck.display();
        duck.quack();
        duck.fly();
        System.out.println("************************");
        System.out.println("测试完毕");
    }
}
