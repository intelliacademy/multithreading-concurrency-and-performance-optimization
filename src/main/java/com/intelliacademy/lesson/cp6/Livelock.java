package com.intelliacademy.lesson.cp6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class Livelock {

    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public void method1(){
        while(true){
            try {
                lock1.tryLock(50, TimeUnit.MICROSECONDS);
                System.out.println("Method 1 executed");
            } catch (Exception e) {
                System.out.println("Method 1: Waiting for lock 1");
            }finally {
                lock1.unlock();
            }
        }
    }

    public void method2(){
        while(true){
            try {
                lock2.tryLock(50, TimeUnit.MICROSECONDS);
                System.out.println("Method 2 executed ");
            } catch (Exception e) {
                System.out.println("Method 2: Waiting for lock 2");
            }finally {
                lock2.unlock();
            }
        }
    }

}
class LivelockMain {
    public static void main(String[] args) {
        Livelock livelock = new Livelock();
        Thread thread1 = new Thread(livelock::method1);
        Thread thread2 = new Thread(livelock::method2);
        thread1.start();
        thread2.start();
    }
}