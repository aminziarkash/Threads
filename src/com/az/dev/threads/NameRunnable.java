package com.az.dev.threads;

/**
 * Created by aziarkash on 1-6-2016.
 */
public class NameRunnable implements Runnable {

    @Override
    public void run() {
        for (int x = 1; x <= 3; x++) {
            System.out.println("Run by\t:\t" + Thread.currentThread().getName() + "\t, x is " + x);
        }
    }
}
