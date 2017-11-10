package com.imooc.pattern.factory.person.impl;

import com.imooc.pattern.factory.person.Boy;
import com.imooc.pattern.factory.person.Girl;
import com.imooc.pattern.factory.person.PersonFactory;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.person.impl
 * @description: 圣诞系列加工厂
 * @date 2017/11/10 20:29
 */
public class McFctory implements PersonFactory {
    @Override
    public Boy getBoy() {
        return new McBoy();
    }

    @Override
    public Girl getGirl() {
        return new McGirl();
    }
}
