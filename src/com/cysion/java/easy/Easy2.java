package com.cysion.java.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * created by cysion on 11/4/2018
 * 28. 搜索二维矩阵
 * 35. 翻转链表
 * //恢复旋转排序数组
 */
public class Easy2 {

    //28. 搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int cur = -1;
        if (matrix[0][0] > target) {
            return false;
        }
        if (matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1] < target) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == target) {
                return true;
            }
            if (matrix[i][matrix[i].length - 1] == target) {
                return true;
            }
            if (matrix[i][0] < target && matrix[i][matrix[i].length - 1] > target) {
                cur = i;
                break;
            }
        }
        if (cur == -1) {
            return false;
        }
        int k = matrix[cur].length;
        for (int j = 0; j < k; j++) {
            if (matrix[cur][j] == target) {
                return true;
            }
        }
        return false;
    }

    public void testMatrix() {
        int[][] A = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(A, 11));
        System.out.println(searchMatrix(A, 21));
        System.out.println(searchMatrix(A, 34));
    }

    class ListNode {
        int x;
        ListNode next;

        public ListNode(int ax) {
            x = ax;
        }
    }

    //35. 翻转链表
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //递归
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        //迭代
//        ListNode newH = null;
//        while (head!=null){
//            ListNode t = head.next;
//            head.next = newH;
//            newH = head;
//            head = t;
//        }
//        return newH;
    }

    public void testReverse() {
        ListNode n0 = new ListNode(4);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(121);
        ListNode n4 = new ListNode(222);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode foo = n0;
        while (foo != null) {
            System.out.print(foo.x + "-->");
            foo = foo.next;
        }
        System.out.println("\n翻转链表...");
        ListNode reverse = reverse(n0);
        while (reverse!=null){
            System.out.print(reverse.x+"-->");
            reverse = reverse.next;
        }
    }

    //恢复旋转排序数组
    public List<Integer> recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if(nums==null||nums.size()==0){
            return nums;
        }
        Integer min = nums.get(0);
        int k = 0;
        int n  = nums.size();
        for(int i = 1;i<n;i++){
            if(nums.get(i)<min){
                k = i;
                min = nums.get(i);
            }
        }
        if(k==0){
            return nums;
        }
        List<Integer> newN = new ArrayList();
        for(int i=0;i<n-k;i++){
            newN.add(nums.get(i+k));
        }
        for(int i= 0;i<k;i++){
            newN.add(nums.get(i));
        }
        nums = newN;
        return nums;
    }

    public void testrecoverRotatedSortedArray(){
        List<Integer> newN = new ArrayList();
        newN.add(7);
        newN.add(8);
        newN.add(9);
        newN.add(10);
        newN.add(1);
        newN.add(2);
        newN.add(3);
        newN.add(4);
        newN.add(5);
        newN.add(6);
        for (Integer integer : newN) {
            System.out.print(integer+",");
        }
        System.out.println("\n翻转后...");
        newN = recoverRotatedSortedArray(newN);
        for (Integer integer : newN) {
            System.out.print(integer+",");
        }
    }
}
