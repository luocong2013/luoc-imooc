package com.imooc.pattern.adapter;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.adapter
 * @description: 采用继承方式的插座适配器
 * @date 2017/11/9 22:44
 */
public class TwoPlugAdapterExtends extends GbTwoPlug implements ThreePlugIf {

    @Override
    public void powerWithThree() {
        System.out.println("借助继承适配器");
        this.powerWithTwo();
    }
}
