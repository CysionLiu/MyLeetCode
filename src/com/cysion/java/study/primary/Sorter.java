package com.cysion.java.study.primary;

import com.cysion.java.study.Utils;

public class Sorter {

    public static int less(Comparable a, Comparable b) {
        return a.compareTo(b);
    }

    public static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void show(Comparable[] arr) {
        System.out.println();
        System.out.println("----------------新数组-----------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].toString() + " > ");
        }
        System.out.println();
        System.out.println("新数组是否有序：" + isSorted(arr));
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (less(arr[i], arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }


    //冒泡排序
    public static void bubble(Comparable[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (less(arr[j], arr[j + 1]) > 0) {
                    exch(arr, j, j + 1);
                }
            }
        }
        System.out.println("\n冒泡排序：");
        show(arr);
    }

    //选择排序
    public static void selection(Comparable[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if (less(arr[min], arr[j]) > 0) {
                    min = j;
                }
            }
            exch(arr, i, min);
        }
        System.out.println("\n选择排序：");
        show(arr);
    }

    //插入排序
    public static void insertion(Comparable[] arr) {

    }
}
