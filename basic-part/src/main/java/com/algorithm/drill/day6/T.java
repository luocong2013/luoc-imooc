package com.algorithm.drill.day6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T {
    private static Pattern pattern = Pattern.compile("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?");

    public static void main(String[] args) {
        Matcher matcher = pattern.matcher("http://www.baidu.com/");
        boolean b = matcher.matches();
        System.out.println(b);
    }

}
