package com.intelliacademy.lesson.cp5.impl;



public class MemoryManagement {
    public static void main(String[] args) {
        //Run with Debug mode
        System.out.println("Main thread proceed on " + Thread.currentThread().getName());

        somethingDoIt();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread proceed on " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread2 proceed on " + i);
            }
        });

        thread.start();
        thread2.start();
        System.out.println("Main thread proceed on " + Thread.currentThread().getName());
    }

    public static void somethingDoIt(){
        System.out.println("Main thread proceed on " + Thread.currentThread().getName());
        anotherDoIt();
    }

    public static void anotherDoIt(){
        System.out.println("Main thread proceed on " + Thread.currentThread().getName());
    }
}
