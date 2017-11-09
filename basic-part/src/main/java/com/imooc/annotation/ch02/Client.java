package com.imooc.annotation.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.annotation.ch02
 * @description: 测试类
 * @date 2017/11/9 22:12
 */
public class Client {
    public static void main(String[] args) {
        Person person = new Child();
        person.age();
    }
}
