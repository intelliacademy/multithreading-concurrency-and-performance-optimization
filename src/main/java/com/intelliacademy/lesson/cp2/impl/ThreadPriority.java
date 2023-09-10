package com.intelliacademy.lesson.cp2.impl;

import com.intelliacademy.lesson.env.XIterableRunnable;

public class ThreadPriority {
    public static void main(String[] args) {
        XIterableRunnable xRunnable = new XIterableRunnable();
        Thread workerThread1 = new Thread(xRunnable, "Worker 1");

        Thread workerThread2 = new Thread(xRunnable, "Worker 2");
        workerThread1.setPriority(Thread.MAX_PRIORITY);

        workerThread1.start();
        workerThread2.start();

    }
}
