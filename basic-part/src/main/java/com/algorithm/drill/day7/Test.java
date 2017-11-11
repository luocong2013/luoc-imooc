package com.algorithm.drill.day7;

public class Test {

    public static void main(String[] args) {
        int i = 0;
        Integer j = new Integer(0);
        System.out.println(i == j);
        System.out.println(j.equals(i));
        String str = "luo";
        String str3 = "luo";
        String str2 = new String("luo");
        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str.equals(str2));
    }

}
