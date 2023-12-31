package com.intelliacademy.lesson.env;

public class Counter {
    private int count = 0;

    //May be synchronized
    public void increment() {
        //count = count + 1;
        count++;
    }

    //May be synchronized
    public void decrement() {
        //count = count - 1;
        count--;
    }

    public int getCount() {
        return count;
    }
}
