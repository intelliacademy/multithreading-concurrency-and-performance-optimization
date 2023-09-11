package com.intelliacademy.lesson.env;

public class SynchronizedCounter {
    private volatile int count = 0;

    //May be synchronized
    public synchronized void increment() {
        //count = count + 1;
        count++;
    }

    //May be synchronized
    public void decrement() {
        //count = count - 1;
        synchronized (this) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
