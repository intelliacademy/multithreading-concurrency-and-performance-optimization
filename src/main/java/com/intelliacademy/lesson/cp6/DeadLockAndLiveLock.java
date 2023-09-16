package com.intelliacademy.lesson.cp6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockAndLiveLock {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);


    public void execute(){
        this.firstWorker();
        this.secondWorker();
    }

    public void firstWorker(){
        lock1.lock();
        try {
            Thread.sleep(1000);
            System.out.println("Download 1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("First worker");
        lock1.unlock();
        lock2.unlock();
    }

    public void secondWorker(){
        lock2.lock();
        try {
            System.out.println("Download 2");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock1.lock();
        System.out.println("Second worker");
        lock1.unlock();
        lock2.unlock();
    }
}

class Main{
    public static void main(String[] args) {
        DeadLockAndLiveLock deadLockAndLiveLock = new DeadLockAndLiveLock();
        Thread thread1 = new Thread(deadLockAndLiveLock::execute);
        Thread thread2 = new Thread(deadLockAndLiveLock::execute);
        thread1.start();
        thread2.start();
    }
}
