package com.intelliacademy.lesson.env;

public class SynchronizedCounter {
    private volatile int count = 0;

    public synchronized void increment() {
        //count = count + 1;
        count++;
    }

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
