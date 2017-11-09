package com.imooc.annotation.ch05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.annotation.ch05
 * @description: TODO
 * @date 2017/11/9 22:33
 */
public class TestMain {

    public static void main(String[] args) {
        Filter f1 = new Filter();
        // 查询id为10的用户
        f1.setId(10);

        Filter f2 = new Filter();
        // 查询用户名为lucy的用户
        f2.setUserName("lucy");
        f2.setAge(18);

        Filter f3 = new Filter();
        // 查询邮箱为其中任意一个的用户
        f3.setEmail("liu@sina.com, zh@163.com, 77777@qq.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
    }

    private static String query(Filter f) {
        StringBuilder builder = new StringBuilder();
        // 1. 获取到class
        Class<?> tCls = f.getClass();
        // 2. 获取到table的名字
        boolean exists = tCls.isAnnotationPresent(Table.class);
        if (!exists) {
            return null;
        }
        Table t = tCls.getAnnotation(Table.class);
        String tableName = t.value();
        builder.append("SELECT * FROM ");
        builder.append(tableName);
        builder.append(" WHERE 1=1");
        // 3. 遍历所有的字段
        Field[] fields = tCls.getDeclaredFields();
        for (Field field : fields) {
            // 4. 处理每个字段对应的sql
            // 4.1 拿到字段名
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            // 4.2 拿到字段值
            String filedName = field.getName();
            String getMethodName = "get"
                    + filedName.substring(0, 1).toUpperCase()
                    + filedName.substring(1);
            Object fieldValue = null;
            try {
                Method getMethod = tCls
                        .getMethod(getMethodName, new Class[]{});
                fieldValue = getMethod.invoke(f, new Object[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 4.3 拼装sql
            if (fieldValue == null
                    || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                continue;
            }
            builder.append(" AND ");
            builder.append(columnName);
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    builder.append(" in(");
                    for (String v : values) {
                        builder.append("'");
                        builder.append(v);
                        builder.append("'");
                        builder.append(",");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    builder.append(")");
                } else {
                    builder.append("=");
                    builder.append("'");
                    builder.append(fieldValue);
                    builder.append("'");
                }
            } else if (fieldValue instanceof Integer) {
                builder.append("=");
                builder.append(fieldValue);
            }
        }
        return builder.toString();
    }
}
