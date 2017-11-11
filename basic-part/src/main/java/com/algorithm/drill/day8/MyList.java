package com.algorithm.drill.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class MyList {

    public List<String> strings = null;

    public MyList() {
        strings = new ArrayList<String>();
    }

    public void addList() {
        for (int i = 0; i < 10; i++) {
            strings.add("LuoCong" + i);
        }
    }

    public void showList() {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public void nextList() {
        ListIterator<String> listIterator = strings.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            System.out.println(listIterator.nextIndex());
        }
    }

    public void previousList() {
        ListIterator<String> listIterator = strings.listIterator(strings.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
            System.out.println(listIterator.previousIndex());
        }
    }

    public void toArray() {
        System.out.println(Arrays.toString(strings.toArray()));
    }

    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.addList();
        myList.showList();
        System.out.println("===nextList====");
        myList.nextList();
        System.out.println("===previousList====");
        myList.previousList();
        System.out.println("===toArray===");
        myList.toArray();
    }

}
