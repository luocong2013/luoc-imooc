package com.imooc.annotation.ch04;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.annotation.ch04
 * @description: TODO
 * @date 2017/11/9 22:20
 */
@Description(desc = "I am Class Annotation", author = "LuoC")
public class TestAnno {

    @Description(desc = "I am eyeColor", author = "Luo", age = 18)
    public String eyeColor() {
        return "red";
    }
}
