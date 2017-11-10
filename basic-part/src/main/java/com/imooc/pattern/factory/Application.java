package com.imooc.pattern.factory;

import com.imooc.pattern.factory.hair.HairFactory;
import com.imooc.pattern.factory.hair.HairInterface;
import com.imooc.pattern.factory.hair.impl.LeftHair;
import com.imooc.pattern.factory.person.Boy;
import com.imooc.pattern.factory.person.Girl;
import com.imooc.pattern.factory.person.PersonFactory;
import com.imooc.pattern.factory.person.impl.HnFactory;
import com.imooc.pattern.factory.person.impl.McFctory;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory
 * @description: 测试类
 * @date 2017/11/10 20:32
 */
public class Application {
    public static void main(String[] args) {
        HairInterface left = new LeftHair();
        left.draw();

        HairFactory factory = new HairFactory();
        HairInterface right = factory.getHair("right");
        right.draw();

        HairInterface left2 = factory.getHairByClass(LeftHair.class.getName());
        left2.draw();

        PersonFactory mcFactory = new McFctory();
        Girl mcGirl = mcFactory.getGirl();
        mcGirl.drawWomen();

        PersonFactory hnFactory = new HnFactory();
        Boy hnBoy = hnFactory.getBoy();
        hnBoy.drawMan();
    }
}
