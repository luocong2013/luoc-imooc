package com.imooc.pattern.factory.person.impl;

import com.imooc.pattern.factory.person.Girl;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.person.impl
 * @description: 圣诞系列的女孩子
 * @date 2017/11/10 20:26
 */
public class McGirl implements Girl {
    @Override
    public void drawWomen() {
        System.out.println("-----------------圣诞系列的女孩子--------------------");
    }
}
