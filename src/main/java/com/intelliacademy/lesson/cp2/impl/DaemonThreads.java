package com.intelliacademy.lesson.cp2.impl;

public class DaemonThreads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println("Daemon thread proceed on " + i);
            }
        });
        thread.setName("Daemon thread");
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        System.out.println("Main thread finished");
    }
}
