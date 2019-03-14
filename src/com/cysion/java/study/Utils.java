package com.cysion.java.study;

import com.cysion.java.study.primary.Sorter;

import java.util.*;

public class Utils {

    public static Integer[] intToInteger(int[] src) {
        Integer[] desc = new Integer[src.length];
        for (int i = 0; i < src.length; i++) {
            desc[i] = src[i];
        }
        return desc;
    }


    public static Integer[] randArr(int n, boolean positive) {
        System.out.println("\n----------------原数组----------------------");
        List<Integer> tmp = new ArrayList<>();
        int low = positive ? 0 : (-n);
        for (int i = low; i < n; i++) {
            if (new Random().nextBoolean()) {
                tmp.add(i);
            }
        }
        Collections.shuffle(tmp);
        Integer[] arr = new Integer[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            System.out.print(tmp.get(i) + " > ");
            arr[i] = tmp.get(i);
        }
        System.out.println();
        System.out.println("原数组是否有序：" + Sorter.isSorted(arr));
        return arr;
    }

    public static Integer[] randMurmur(int n) {
        System.out.println("\n----------------原数组----------------------");
        List<Integer> tmp = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (new Random().nextBoolean()) {
                tmp.add(new Random().nextInt(i));
            }
        }
        Collections.shuffle(tmp);
        Integer[] arr = new Integer[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            System.out.print(tmp.get(i) + " > ");
            arr[i] = tmp.get(i);
        }
        System.out.println();
        System.out.println("原数组是否有序：" + Sorter.isSorted(arr));
        return arr;
    }
}
