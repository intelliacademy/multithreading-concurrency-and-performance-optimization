package com.intelliacademy.lesson.env;




public class XIterableRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
            System.out.println(Thread.currentThread().getName() + " thread proceed on " + i);
            System.out.println(Thread.currentThread().getName() + " thread state is " + Thread.currentThread().getState().name());
            System.out.println(Thread.currentThread().getName() + " thread priority is " + Thread.currentThread().getPriority());
            System.out.println(Thread.currentThread().getName() + " thread is " + (Thread.currentThread().isAlive() ? "alive" : "dead"));
            System.out.println(Thread.currentThread().getName() + " thread is " + (Thread.currentThread().isDaemon() ? "daemon" : "not daemon"));
            System.out.println(Thread.currentThread().getName() + " thread is " + (Thread.currentThread().isInterrupted() ? "interrupted" : "not interrupted"));
        }
    }
}



