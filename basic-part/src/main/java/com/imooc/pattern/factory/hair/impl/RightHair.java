package com.imooc.pattern.factory.hair.impl;

import com.imooc.pattern.factory.hair.HairInterface;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.hair.impl
 * @description: 右偏分发型
 * @date 2017/11/10 20:20
 */
public class RightHair implements HairInterface {
    @Override
    public void draw() {
        System.out.println("-----------------右偏分发型-------------------");
    }
}
