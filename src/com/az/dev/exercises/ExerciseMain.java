package com.az.dev.exercises;

/**
 * Created by aziarkash on 3-6-2016.
 */
public class ExerciseMain {

    public static void main(String[] args) {
        MyExerciseRunnable runnable = new MyExerciseRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
