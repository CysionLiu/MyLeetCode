package com.cysion.java.fresh;

/**
 * lintcode入门级题目
 * created by Cysion(刘咸尚) on 23th March 2018
 * 37. 反转一个3位整数
 * 145. 大小写转换
 *
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
        if(tmp>96&&tmp<123){
            return (char)(tmp-32);
        }
        return character;
    }
    public void testL2U(){
        System.out.println("大小写转换...");
        System.out.println(lowercaseToUppercase('a'));
        System.out.println(lowercaseToUppercase('b'));
        System.out.println(lowercaseToUppercase('v'));
        System.out.println(lowercaseToUppercase('w'));
        System.out.println(lowercaseToUppercase('&'));
    }
}
