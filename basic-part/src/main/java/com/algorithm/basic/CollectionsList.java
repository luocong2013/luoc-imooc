package com.algorithm.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.basic
 * @description: TODO
 * @date 2017/11/11 17:23
 */
public class CollectionsList {

    char[] src = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private List<String> strings = null;

    public CollectionsList() {
        strings = new ArrayList<>();
    }

    public void addString() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            StringBuilder builder = null;
            do {
                builder = new StringBuilder();
                for (int j = 0; j <= random.nextInt(101); j++) {
                    builder.append(src[random.nextInt(52)]);
                }
            } while (strings.contains(builder.toString()));
            strings.add(builder.toString());
        }
    }


    public void forEachList() {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        CollectionsList cl = new CollectionsList();
        cl.addString();
        cl.forEachList();
    }
}
