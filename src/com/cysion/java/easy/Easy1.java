package com.cysion.java.easy;

/**
 * by cysion 2018.4.2
 * //1. A + B 问题
 * //2. 尾部的零
 * //6. 合并排序数组 II
 */
public class Easy1 {

    //1. A + B 问题
    public int aplusb(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        int x = a ^ b;
        int y = (a & b) << 1;
        return aplusb(x, y);
    }

    public void testAPlusB() {
        System.out.println("19+24=" + aplusb(19, 24));
        System.out.println("129+524=" + aplusb(129, 524));
    }

    //2. 尾部的零
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long c = 0;
        while (n / 5 > 0) {
            c = c + n / 5;
            n = n / 5;
            ;
        }
        return c;
    }

    public void testEnd0() {
        System.out.println(trailingZeros(11));
        System.out.println(trailingZeros(131));
        System.out.println(trailingZeros(55));
    }

    //6. 合并排序数组 II
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int a = 0;
        int b = 0;
        int[] r = new int[A.length + B.length];
        while (a < A.length && b < B.length) {
            if (A[a] <= B[b]) {
                r[a + b] = A[a];
                a++;
            } else {
                r[a + b] = B[b];
                b++;
            }
        }
        if (a == A.length) {
            for (int i = b; i < B.length; i++) {
                r[a + i] = B[i];
            }
        } else if (b == B.length) {
            for (int i = a; i < A.length; i++) {
                r[b + i] = A[i];
            }
        }
        return r;
    }

    public void testMergeSorted() {
        int[] A = {1,5};
        int[] B = {2,3};
        for (int i : mergeSortedArray(A, B)) {
            System.out.println("" + i);
        }
    }
}
