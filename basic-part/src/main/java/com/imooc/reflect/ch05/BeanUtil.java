package com.imooc.reflect.ch05;

import java.lang.reflect.Method;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.reflect.ch05
 * @description: TODO
 * @date 2017/11/11 16:06
 */
public class BeanUtil {
    /**
     * 根据标准JavaBean对象的属性名获取其属性值
     *
     * @param obj
     * @param propertyName
     * @return
     */
    public static Object getValueByPropertyName(Object obj, String propertyName) {
        // 1.根据属性名称就可以获取其get方法
        String getMethodName = "get"
                + propertyName.substring(0, 1).toUpperCase()
                + propertyName.substring(1);
        //2.获取方法对象
        Class<?> c1 = obj.getClass();
        try {
            //get方法都是public的且无参数
            Method m1 = c1.getMethod(getMethodName);
            //3. 通过方法的反射操作方法
            Object value = m1.invoke(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
