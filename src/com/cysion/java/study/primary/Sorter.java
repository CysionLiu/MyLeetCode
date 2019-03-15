package com.cysion.java.study.primary;

import com.cysion.java.study.Utils;

public class Sorter {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
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
            if (less(arr[i + 1], arr[i])) {
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
                if (less(arr[j + 1], arr[j])) {
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
                if (less(arr[j], arr[min])) {
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
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) {
                    exch(arr, j, j - 1);
                }
            }
        }
        System.out.println("\n插入排序：");
        show(arr);
    }

    //希尔排序
    public static void shill(Comparable[] arr) {
        int N = arr.length;
        int step = N / 2;
        while (step >= 1) {
            for (int i = 0; i < step; i++) {
                for (int j = step + i; j < N; j += step) {
                    for (int k = j; k >= step; k -= step) {
                        if (less(arr[k], arr[k - step])) {
                            exch(arr, k, k - step);
                        }
                    }
                }
            }
            step /= 2;
        }
        System.out.println("\n希尔排序：");
        show(arr);
    }

    //归并排序的辅助数组
    private static Comparable[] mergeAux;

    //归并排序
    public static void sortMerge(Comparable[] arr) {
        int N = arr.length;
        mergeAux = new Comparable[N];
        sortMerge(arr, 0, N-1);
        System.out.println("\n归并排序：");
        show(arr);
    }

    private static void sortMerge(Comparable[] arr, int low, int hi) {
        if (hi <= low) {
            return;
        }
        int mid = (hi + low) / 2;
        sortMerge(arr, low, mid);
        sortMerge(arr, mid + 1, hi);
        combine(arr, low, mid, hi);
    }

    private static void combine(Comparable[] arr, int low, int mid, int hi) {
        int p = low;
        int q = mid + 1;
        for(int k=low;k<=hi;k++){
            mergeAux[k] = arr[k];
        }
        for (int i = low; i <= hi; i++) {
            if (p > mid) {
                arr[i] = mergeAux[q++];
                continue;
            }
            if (q > hi) {
                arr[i] = mergeAux[p++];
                continue;
            }
            if (less(mergeAux[p], mergeAux[q])) {
                arr[i] = mergeAux[p++];
            } else {
                arr[i] = mergeAux[q++];
            }
        }
    }
}
