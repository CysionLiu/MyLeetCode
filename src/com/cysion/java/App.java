package com.cysion.java;

import com.cysion.java.fresh.EasyQ;

public class App {

    private EasyQ easyQ;

    public App() {
        easyQ = new EasyQ();

    }

    public void run() {
        System.out.println("运行..");
//        easyQ.testReverse();
        easyQ.testL2U();

    }
}
