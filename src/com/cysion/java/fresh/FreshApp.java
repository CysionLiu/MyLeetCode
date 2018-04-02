package com.cysion.java.fresh;

public class FreshApp {

    private Fresh fresh;

    public FreshApp() {
        fresh = new Fresh();
    }

    public void run() {
        System.out.println("运行..");
//        fresh.testReverse();
//        fresh.testL2U();
//        fresh.testfibonacci();
//        fresh.testRemoveElement();
//        fresh.testSort();
//        fresh.testCountNodes();
        fresh.testhexConversion();
    }
}