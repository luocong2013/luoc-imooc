package com.imooc.pattern.factory.person.impl;

import com.imooc.pattern.factory.person.Boy;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.person.impl
 * @description: 新年系列的男孩子
 * @date 2017/11/10 20:30
 */
public class HnBoy implements Boy {
    @Override
    public void drawMan() {
        System.out.println("-----------------新年系列的男孩子--------------------");
    }
}
