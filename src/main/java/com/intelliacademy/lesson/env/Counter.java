package com.intelliacademy.lesson.env;

public class Counter {
    private int count = 0;

    public void increment() {
        //count = count + 1;
        count++;
    }

    public void decrement() {
        //count = count - 1;
        count--;
    }

    public int getCount() {
        return count;
    }
}
