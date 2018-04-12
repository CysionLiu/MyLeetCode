package com.cysion.java.easy;

public class EasyApp {

    private Easy1 easy1;
    private Easy2 easy2;

    public EasyApp() {
        easy1 = new Easy1();
        easy2 = new Easy2();
    }
    public void run(){
//        easy1.testAPlusB();
//        easy1.testEnd0();
//        easy1.testMergeSorted();
//        easy1.testRotate();
//        easy1.testStr();
//        easy1.testBineary();
//        easy2.testMatrix();
//        easy2.testReverse();
        easy2.testrecoverRotatedSortedArray();
    }
}
