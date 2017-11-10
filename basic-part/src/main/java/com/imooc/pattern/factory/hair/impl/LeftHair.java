package com.imooc.pattern.factory.hair.impl;

import com.imooc.pattern.factory.hair.HairInterface;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.hair.impl
 * @description: 左偏分发型
 * @date 2017/11/10 20:21
 */
public class LeftHair implements HairInterface {
    @Override
    public void draw() {
        System.out.println("-----------------左偏分发型-------------------");
    }
}
