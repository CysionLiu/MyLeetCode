package com.cysion.java.study.primary;

import com.cysion.java.study.MyIterator;
import com.cysion.java.study.Utils;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class App {
    public static void main(String[] args) {
//        testGcd();
//        testBs(args);
//        testStack();
//        testQueue();
        testSort();

    }

    //    测试排序
    private static void testSort() {
        Sorter.bubble(Utils.randArr(200, true));
        Sorter.selection(Utils.randArr(200, false));
        Sorter.insertion(Utils.randArr(200, false));
        Sorter.bubble(Utils.randMurmur(200));
        Sorter.selection(Utils.randMurmur(200));
        Sorter.insertion(Utils.randMurmur(200));

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


    public static void testStack() {
        MyLinkedStack<String> myStack = new MyLinkedStack<>();
        while (!StdIn.isEmpty()) {
            String t = StdIn.readString();
            if ("p".equals(t)) {
                myStack.pop();
            } else {
                myStack.push(t);
            }
            MyIterator iterator = myStack.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + "-");
            }
            System.out.println("");
        }
    }

    public static void testQueue() {
        MyQueue<String> myStack = new MyQueue<>();
        while (!StdIn.isEmpty()) {
            String t = StdIn.readString();
            if ("p".equals(t)) {
                myStack.dequeue();
            } else {
                myStack.enqueue(t);
            }
            MyIterator iterator = myStack.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + "-");
            }
            System.out.println("");
        }
    }
}

