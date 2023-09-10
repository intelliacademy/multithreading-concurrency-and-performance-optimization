package com.intelliacademy.lesson.env;




public class XRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from ".concat(Thread.currentThread().getName()));
        System.out.println("Thread state is ".concat(Thread.currentThread().getState().name()));
    }
}



