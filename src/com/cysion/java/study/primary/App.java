package com.cysion.java.study.primary;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class App {
    public static void main(String[] args) {
//        testGcd();
        testBs(args);
    }

    //测试最大公约数
    private static void testGcd() {
        System.out.println(Case1.gcd(1328, 128));
        System.out.println(Case1.gcd(2332, 36));
        System.out.println(Case1.gcd(632, 16));
    }

    //测试二分查找
    private static void testBs(String[] args) {
        int[] ints = new In("./txt/random_array_300").readAllInts();
        Arrays.sort(ints);
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            if (Case1.binarySearch(i, ints) < 0) {
                System.out.println("not in");
            } else {
                System.out.println("in");
            }
        }
    }


    private static void randarr() {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            if (new Random().nextBoolean()) {
                tmp.add(i);
            }

        }
        Collections.shuffle(tmp);
        System.out.println();
        tmp.forEach(integer ->
        {
            System.out.print(integer + " ");
        });
    }
}

