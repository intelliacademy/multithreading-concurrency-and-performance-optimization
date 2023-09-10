package com.intelliacademy.lesson.cp2.impl;

import com.intelliacademy.lesson.cp2.impl.StartingThreadWithRunnable;

import com.intelliacademy.lesson.env.ProcessManager;

import java.util.stream.IntStream;


public class StartingThreadWithRunnable {

    public static void main(String[] args) {
        //Time-slicing is a method to share CPU time between multiple threads in single processor.
        Thread thread1 = new Thread(new AnyManager("Task 1"));
        Thread thread2 = new Thread(new AnyManager("Task 2"));
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i< 100; i++){
                    System.out.println("Task 3 proceed on " + i + " thread " + Thread.currentThread().getName());
                }
            }
        });
        Thread thread4 = new Thread(() -> IntStream.rangeClosed(0, 100).forEach(i -> {
            System.out.println("Task 4 proceed on " + i + " thread " + Thread.currentThread().getName());
        }));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
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
