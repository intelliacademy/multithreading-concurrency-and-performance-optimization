package com.intelliacademy.lesson.cp5.impl;

import com.intelliacademy.lesson.env.Counter;
import com.intelliacademy.lesson.env.SynchronizedCounter;


public class Synchronization {
    public static Integer HUNDRED = 100;

    public static Integer THOUSAND = 1000;

    public static Integer TEN_THOUSAND = 10000;

    public static void main(String[] args) {
        Counter counter = new Counter();
        //SynchronizedCounter counter = new SynchronizedCounter();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < TEN_THOUSAND; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < TEN_THOUSAND; i++) {
                counter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
            System.out.println("Counter value is " + counter.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
