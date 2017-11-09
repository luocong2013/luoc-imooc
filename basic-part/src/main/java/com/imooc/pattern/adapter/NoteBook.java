package com.imooc.pattern.adapter;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.adapter
 * @description: 测试类
 * @date 2017/11/9 22:45
 */
public class NoteBook {
    private ThreePlugIf plug;

    public NoteBook(ThreePlugIf plug) {
        super();
        this.plug = plug;
    }

    /**
     * 使用插座充电
     */
    public void charge() {
        plug.powerWithThree();
    }

    public static void main(String[] args) {
        GbTwoPlug two = GbTwoPlug.getInstance();
        ThreePlugIf three = new TwoPlugAdapter(two);
        NoteBook nb = new NoteBook(three);
        nb.charge();

        three = new TwoPlugAdapterExtends();
        nb = new NoteBook(three);
        nb.charge();
    }
}
