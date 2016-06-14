package com.az.dev.main;

/**
 * Created by aziarkash on 1-6-2016.
 */
public class NameRunnable implements Runnable {

    @Override
    public void run() {
        for (int x = 1; x <= 3; x++) {
            System.out.println("Run by\t:\t" + Thread.currentThread().getName() + ",\t x is " + x);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("InterruptedException Exception Caught!");
            }
        }
    }
}
