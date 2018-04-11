package com.cysion.java.easy;

/**
 * created by cysion on 11/4/2018
 * 28. 搜索二维矩阵
 */
public class Easy2 {

    //28. 搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int n = matrix.length;
        if(n==0){
            return false;
        }
        int cur = -1;
        if(matrix[0][0]>target){
            return false;
        }
        if(matrix[matrix.length-1][matrix[matrix.length-1].length-1]<target){
            return false;
        }
        for(int i=0;i<n;i++){
            if(matrix[i][0]==target){
                return true;
            }
            if(matrix[i][matrix[i].length-1]==target){
                return true;
            }
            if(matrix[i][0]<target&&matrix[i][matrix[i].length-1]>target){
                cur = i;
                break;
            }
        }
        if(cur==-1){
            return false;
        }
        int k = matrix[cur].length;
        for(int j=0;j<k;j++){
            if(matrix[cur][j]==target){
                return true;
            }
        }
        return false;
    }

    public void testMatrix(){
        int[][] A = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(searchMatrix(A,11));
        System.out.println(searchMatrix(A,21));
        System.out.println(searchMatrix(A,34));
    }
}
