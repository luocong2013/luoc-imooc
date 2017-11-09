package com.imooc.pattern.adapter;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.adapter
 * @description: 二相转三相的插座适配器
 * @date 2017/11/9 22:43
 */
public class TwoPlugAdapter implements ThreePlugIf {

    private GbTwoPlug plug;

    public TwoPlugAdapter(GbTwoPlug plug) {
        super();
        this.plug = plug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("通过转化");
        plug.powerWithTwo();
    }
}
