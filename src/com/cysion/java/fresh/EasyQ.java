package com.cysion.java.fresh;

import java.util.ArrayList;
import java.util.List;

/**
 * lintcode入门级题目
 * created by Cysion(刘咸尚) on 23th March 2018
 * 37. 反转一个3位整数
 * 145. 大小写转换
 * 366. 斐波纳契数列
 * 452. 删除链表中的元素
 * 463. 整数排序--冒泡
 * 632. 二叉树的最大节点
 * 763. Hex Conversion
 */
public class EasyQ {

    //37. 反转一个3位整数
    public int reverse(int num) {
        if (num > 999 || num < 100) {
            return num;
        }
        return (num % 10) * 100 + 10 * ((num / 10) % 10) + num / 100;
    }

    public void testReverse() {
        System.out.println("反转一个3位整数...");
        System.out.println(reverse(213));
        System.out.println(reverse(643));
        System.out.println(reverse(907));
        System.out.println(reverse(1205));
    }

    //145. 大小写转换
    public char lowercaseToUppercase(char character) {
        int tmp = character;
        if (tmp > 96 && tmp < 123) {
            return (char) (tmp - 32);
        }
        return character;
    }

    public void testL2U() {
        System.out.println("大小写转换...");
        System.out.println(lowercaseToUppercase('a'));
        System.out.println(lowercaseToUppercase('b'));
        System.out.println(lowercaseToUppercase('v'));
        System.out.println(lowercaseToUppercase('w'));
        System.out.println(lowercaseToUppercase('&'));
    }

    //366. 斐波纳契数列
    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int p = 1;
        int q = 1;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = p + q;
            p = q;
            q = sum;
        }
        return sum;
    }

    public void testfibonacci() {
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(20));
    }

    static class ListNode {
        int var;
        ListNode next;

        ListNode(int x) {
            var = x;
        }
    }

    //452. 删除链表中的元素
    public ListNode removeElement(ListNode head, int val) {
        ListNode foo = new ListNode(0);
        foo.next = head;
        head = foo;
        while (head.next != null) {
            if (head.next.var == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return foo.next;
    }

    public void testRemoveElement() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(12);
        ListNode node7 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode foo = new ListNode(0);
        foo.next = node1;
        while (foo.next != null) {
            System.out.print(foo.next.var + "->");
            foo.next = foo.next.next;
        }
        node1 = removeElement(node1, 3);
        System.out.println("\n删除值为3后...");
        foo.next = node1;
        while (foo.next != null) {
            System.out.print(foo.next.var + "->");
            foo.next = foo.next.next;
        }
    }

    //463. 整数排序--冒泡
    public int[] sortIntegers(int[] A) {
        int len = A.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int t = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = t;
                }
            }
        }
        return A;
    }

    public void testSort() {
        int[] a = {4, 2, 67, 3, 98, 6, 1, 10, 95, 45, 32, 12};
        int[] b = {111, 2, 444, 3, 1, 6, 666, 10, 95, 451, 2, 12};
        a = sortIntegers(a);
        for (int i : a) {
            System.out.print(i + "->");
        }
        System.out.println("------");
        b = sortIntegers(b);
        for (int i : b) {
            System.out.print(i + "->");
        }
    }

    //466. 链表节点计数
    public int countNodes(ListNode head) {
        // write your code here
        if (head == null) {
            return 0;
        }
        int c = 1;
        while (head.next != null) {
            c++;
            head.next = head.next.next;
        }
        return c;
    }

    public void testCountNodes() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(12);
        ListNode node7 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        int n = countNodes(node1);
        System.out.println("节点个数为:" + n);
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // 632. 二叉树的最大节点
    public TreeNode treenode = new TreeNode(Integer.MIN_VALUE);

    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if (root == null)
            return null;
        else {
            if (root.val > treenode.val)
                treenode = root;
            maxNode(root.left);
            maxNode(root.right);
        }
        return treenode;
    }

    //763. Hex Conversion
    public String hexConversion(int n, int k) {
        // write your code here
        List<Integer> a = new ArrayList();
        while (n / k != 0) {
            a.add(n % k);
            n = n / k;
        }
        a.add(n % k);
        StringBuilder builder = new StringBuilder();
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) > 9) {
                char c = (char) (a.get(i) + 55);
                builder.append(c);
            } else {
                builder.append(a.get(i) + "");
            }
        }
        return builder.toString();
    }

    public void testhexConversion() {
        System.out.println(hexConversion(5, 2));
        System.out.println(hexConversion(30, 16));
        System.out.println(hexConversion(42, 8));
    }
}
