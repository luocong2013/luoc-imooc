package com.imooc.pattern.factory.person;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.factory.person
 * @description: 人物的实现接口
 * @date 2017/11/10 20:25
 */
public interface PersonFactory {
    /**
     * 男孩接口
     */
    Boy getBoy();

    /**
     * 女孩接口
     */
    Girl getGirl();
}
