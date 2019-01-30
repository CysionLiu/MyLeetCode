package com.cysion.java.study.primary;

public class Case1 {
    //最大公约数
    static int gcd(int p, int q) {
        if (q > p) {
            int t = p;
            p = q;
            q = t;
        }
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    //二分查找
    static int binarySearch(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key > arr[mid]) {
                lo = mid + 1;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
