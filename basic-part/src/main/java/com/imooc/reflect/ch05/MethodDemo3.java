package com.imooc.reflect.ch05;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.reflect.ch05
 * @description: TODO
 * @date 2017/11/11 16:06
 */
public class MethodDemo3 {
    public static void main(String[] args) {
        User u1 = new User("张三", "123456", 29);
        System.out.println(BeanUtil.getValueByPropertyName(u1, "username"));
        System.out.println(BeanUtil.getValueByPropertyName(u1, "userpass"));
    }
}
