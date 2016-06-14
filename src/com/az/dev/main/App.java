package com.az.dev.main;

/**
 * Created by aziarkash on 27-5-2016.
 */
public class App {

    public static String objectiveString;

    public static void main(String[] args) {

        App app = new App();

        // DEFINING INSTANTIATING AND STARTING
        app.definingThread();

        app.runByName();

        app.startingAndRunningMultipleThreads();

        app.threadScheduler();

    }

    private void threadScheduler() {
        NameRunnable nr = new NameRunnable();
        Thread thread = new Thread(nr);
        thread.setName(System.getProperty("user.name"));
        thread.setPriority(9); // 1 - 10
        thread.start();
    }

    private void startingAndRunningMultipleThreads() {
        NameRunnable nr = new NameRunnable();
        Thread t1 = new Thread(nr);
        Thread t2 = new Thread(nr);
        Thread t3 = new Thread(nr);

        t1.setName("Amin");
        t2.setName("Varun");
        t3.setName("Xiaochen");

        t1.start();
        t2.start();
        t3.start();
        // t1.start(); NOT POSSIBLE!! will throw an IllegalThreadException
    }

    private void runByName() {
        NameRunnable nr = new NameRunnable();
        Thread thread = new Thread(nr);
        thread.setName("Amin");
        thread.start();
    }


    private void definingThread() {
        definingByExtendingThreadClass();
        definingByImplementingRunnableInterface();
    }

    private void definingByExtendingThreadClass() {
        MyThread myThread = new MyThread();
        myThread.run();
        myThread.run("MyString");
    }

    private void definingByImplementingRunnableInterface() {
        MyRunnable runnable = new MyRunnable();
        Thread a = new Thread(runnable); // pass the runnable (target/target Runnable) to Thread
        Thread b = new Thread(runnable); // runnable can be passed to multiple threads
        Thread c = new Thread(runnable); // again runnable passed (a new thread can also be passed since it implements Runnable)
        System.out.println();
        a.start(); // same job running for multiple threads
        b.start();
        c.start();
    }

    public static void addSub(String objectiveString) {
        for (int i = 0; i < objectiveString.length() + 4; i++) {
            System.out.print("=");
        }
        System.out.println("\n" + "\033[1m* " + objectiveString + " *\033[0m");
        for (int i = 0; i < objectiveString.length() + 4; i++) {
            System.out.print("=");
        }
        System.out.println("\n");
    }

    public static void addSeparator() {
        System.out.println("\n\033[1m**************************************************************************************************************\033[0m");
    }

}

class TestClass implements Runnable {
    volatile int x;
    public void run(){ x = 5; }
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.x = 10;
        new Thread(tc).start(); // 1       
        System.out.println(tc.x);
    }
}

class A extends Thread {

    public void run() {
        System.out.println("Starting loop");
        while (true) {
        }
    }
}

class TestClass1 {

    public static void main(String args[]) throws Exception {
        A a = new A();
        a.start();
        Thread.sleep(1000);
        a.interrupt();
    }
}
