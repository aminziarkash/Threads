package com.az.dev.threads.main;

/**
 * Created by aziarkash on 27-5-2016.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread running");
    }

    // overloaded run method
    public void run(String s) {
        System.out.println("String in run is\t:\t" + s);
    }
}
