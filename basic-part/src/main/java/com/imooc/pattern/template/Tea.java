package com.imooc.pattern.template;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.template
 * @description: 具体子类，提供了制备茶的具体实现
 * @date 2017/11/11 15:17
 */
public class Tea extends RefreshBeverage {
    @Override
    protected void brew() {
        System.out.println("用80度的热水浸泡茶叶5分钟");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入柠檬");
    }

    /**
     * 子类通过覆盖的形式选择挂载钩子函数
     */
    @Override
    protected boolean isCustomerWantsCondiments() {
        return false;
    }
}
