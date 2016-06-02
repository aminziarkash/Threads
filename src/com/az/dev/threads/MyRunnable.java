package com.az.dev.threads;

/**
 * Created by aziarkash on 31-5-2016.
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Job running from my runnable class");
    }
}
