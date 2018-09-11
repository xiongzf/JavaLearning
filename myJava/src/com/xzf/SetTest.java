package com.xzf;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
//        method1();

        method2();

    }

    private static void method2() {
        String[] arr = {"黑桃", "方块", "红桃", "梅花"};
        String[] arr2 = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        ArrayList<String> box = new ArrayList<String>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                box.add(arr[i] + arr2[j]);
            }
        }

        box.add("小王");
        box.add("大王");

        //乱序
        Collections.shuffle(box);
        ArrayList<String> box1 = new ArrayList<String>();
        ArrayList<String> box2 = new ArrayList<String>();
        ArrayList<String> box3 = new ArrayList<String>();

        for (int i = 0; i < box.size() - 3; i++) {
            int j = i % 3;
            switch (j) {
                case 0:
                    box1.add(box.get(i));
                    break;
                case 1:
                    box2.add(box.get(i));
                    break;
                case 2:
                    box3.add(box.get(i));
                    break;
                default:
                    break;
            }
        }

        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);
        for (int i = 3; i > 0; i--) {
            System.out.println(box.get(box.size() - i));
        }
    }

    private static void method1() {
        Set<String> set = new HashSet<String>();
        set.add("张三");
        set.add("李四");
        set.add("王五");

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
