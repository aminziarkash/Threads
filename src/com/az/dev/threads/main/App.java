package com.az.dev.threads.main;

/**
 * Created by aziarkash on 27-5-2016.
 */
public class App {

    private String objectiveString;

    public static void main(String[] args) {

        App app = new App();

        // DEFINING INSTANTIATING AND STARTING

        // app.definingThread();

        // app.runByName();

        // app.startingAndRunningMultipleThreads();

        app.threadScheduler();
    }

    private void threadScheduler() {
        objectiveString = "Using Thread.sleep()";
        addSub(objectiveString);

        NameRunnable nr = new NameRunnable();
        Thread thread = new Thread(nr);
        thread.setName(System.getProperty("user.name"));
        thread.start();

        addSeparator();
    }

    private void startingAndRunningMultipleThreads() {
        objectiveString = "Starting and Running Multiple Threads";
        addSub(objectiveString);

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

        addSeparator();
    }

    private void runByName() {
        objectiveString = "Run threads by name";
        addSub(objectiveString);

        NameRunnable nr = new NameRunnable();
        Thread thread = new Thread(nr);
        thread.setName("Amin");
        thread.start();

        addSeparator();
    }


    private void definingThread() {
        objectiveString = "Defining Thread";
        addSub(objectiveString);

        definingByExtendingThreadClass();

        definingByImplementingRunnableInterface();

        addSeparator();
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

    public void addSub(String objectiveString) {
        for (int i = 0; i < objectiveString.length() + 4; i++) {
            System.out.print("=");
        }
        System.out.println("\n" + "\033[1m* " + objectiveString + " *\033[0m");
        for (int i = 0; i < objectiveString.length() + 4; i++) {
            System.out.print("=");
        }
        System.out.println("\n");
    }

    public void addSeparator() {
        System.out.println("\n\033[1m**************************************************************************************************************\033[0m");
    }

}
