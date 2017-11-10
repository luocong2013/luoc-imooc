package com.imooc.pattern.factory.hair;

import com.imooc.pattern.factory.hair.impl.LeftHair;
import com.imooc.pattern.factory.hair.impl.RightHair;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.hair.impl
 * @description: 发型工厂
 * @date 2017/11/10 20:22
 */
public class HairFactory {
    /**
     * 根据类型来创建对象
     *
     * @param key
     * @return
     */
    public HairInterface getHair(String key) {
        if ("left".equals(key)) {
            return new LeftHair();
        } else if ("right".equals(key)) {
            return new RightHair();
        }
        return null;
    }

    /**
     * 根据类的名称来生产对象
     *
     * @param className
     * @return
     */
    public HairInterface getHairByClass(String className) {
        HairInterface hair = null;
        try {
            hair = (HairInterface) Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hair;
    }
}
