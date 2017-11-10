package com.imooc.pattern.factory.person.impl;

import com.imooc.pattern.factory.person.Boy;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.person.impl
 * @description: 圣诞系列的男孩子
 * @date 2017/11/10 20:27
 */
public class McBoy implements Boy {
    @Override
    public void drawMan() {
        System.out.println("-----------------圣诞系列的男孩子--------------------");
    }
}
