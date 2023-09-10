package com.intelliacademy.lesson.cp2.impl;


import com.intelliacademy.lesson.env.ProcessManager;



public class StartingThreadWithRunnable {

    public static void main(String[] args) {
        //Time-slicing is a method to share CPU time between multiple threads in single processor.
        Thread thread1 = new Thread(new AnyManager("Task 1"));
        Thread thread2 = new Thread(new AnyManager("Task 2"));
        thread1.start();
        thread2.start();
    }

}

class AnyManager implements ProcessManager , Runnable {
    private final String name;
    public AnyManager(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        this.proceed();
    }

    @Override
    public void proceed() {
        for (int i = 0; i< 100; i++){
            System.out.println(name + " task proceed on " + i + " thread " + Thread.currentThread().getName());
        }
    }
}
