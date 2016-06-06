package com.az.dev.threads.exercises;

/**
 * Created by aziarkash on 3-6-2016.
 */
public class MyExerciseRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++) {
            if (i % 10 != 0) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
