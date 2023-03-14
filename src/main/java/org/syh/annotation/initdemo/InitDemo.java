package org.syh.annotation.initdemo;

public class InitDemo {
    @InitMethod(flag = "2")
    public void init() {
        System.out.println("init ...");
    }
}
