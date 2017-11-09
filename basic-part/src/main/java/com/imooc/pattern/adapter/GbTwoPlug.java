package com.imooc.pattern.adapter;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.adapter
 * @description: 国标二相电流
 * @date 2017/11/9 22:42
 */
public class GbTwoPlug {
    private static GbTwoPlug instance = null;

    /**
     * 单例模式
     *
     * @return
     */
    public static GbTwoPlug getInstance() {
        if (instance == null) {
            instance = new GbTwoPlug();
        }
        return instance;
    }

    public void powerWithTwo() {
        System.out.println("使用二相电流供电");
    }
}
