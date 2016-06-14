package com.az.dev.main;

/**
 * Created by aziarkash on 6-6-2016.
 */
public class DeadLockRisk implements Runnable {

    private Resource resourceA = new Resource();

    private Resource resourceB = new Resource();

    @Override
    public void run() {
        read();
        write(87, 87);
    }

    public static void main(String[] args) {
        DeadLockRisk runnable = new DeadLockRisk();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }

    public int read() {
        synchronized (resourceA) { // May deadlock here
            synchronized (resourceB) {
                return resourceB.value + resourceA.value;
            }
        }
    }

    public void write(int a, int b) {
        synchronized (resourceB) { // May deadlock here
            synchronized (resourceA) {
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    }

    private static class Resource {
        public int value;
    }

}
