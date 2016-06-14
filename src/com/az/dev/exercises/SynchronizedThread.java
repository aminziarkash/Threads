package com.az.dev.exercises;

import com.az.dev.main.App;

/**
 * Created by bmziarkash on 6/5/16.
 */
public class SynchronizedThread extends Thread {

    private StringBuffer stringBuffer;

    public SynchronizedThread(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }

    public static void main(String[] args) {
        App.objectiveString = "Synchronizing a block of code";
        App.addSub(App.objectiveString);

        StringBuffer sb = new StringBuffer("A");
        SynchronizedThread thread1 = new SynchronizedThread(sb);
        SynchronizedThread thread2 = new SynchronizedThread(sb);
        SynchronizedThread thread3 = new SynchronizedThread(sb);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        synchronized (stringBuffer) { // cannot use 'this' here
            for (int i = 0; i < 50; i++) {
                System.out.print(stringBuffer);
            }
            System.out.println();
            char c = stringBuffer.charAt(0);
            c++;
            stringBuffer.setCharAt(0, c);
        }
    }
}
