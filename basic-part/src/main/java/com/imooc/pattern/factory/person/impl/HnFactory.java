package com.imooc.pattern.factory.person.impl;

import com.imooc.pattern.factory.person.Boy;
import com.imooc.pattern.factory.person.Girl;
import com.imooc.pattern.factory.person.PersonFactory;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.person.impl
 * @description: 新年系列加工厂
 * @date 2017/11/10 20:31
 */
public class HnFactory implements PersonFactory {
    @Override
    public Boy getBoy() {
        return new HnBoy();
    }

    @Override
    public Girl getGirl() {
        return new HnGirl();
    }
}
