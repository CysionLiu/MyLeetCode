package com.cysion.java.easy;

/**
 * by cysion 2018.4.2
 *  //1. A + B 问题
 */
public class Easy1 {

    //1. A + B 问题
    public int aplusb(int a, int b) {
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        int x = a^b;
        int y = (a&b)<<1;
        return aplusb(x,y);
    }

    public void testAPlusB(){
        System.out.println("19+24="+aplusb(19,24));
        System.out.println("129+524="+aplusb(129,524));
    }
}
