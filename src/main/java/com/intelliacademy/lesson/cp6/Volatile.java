package com.intelliacademy.lesson.cp6;

class Process implements Runnable {
    private Boolean isAlive = true;

    @Override
    public void run() {
        while (isAlive){
            System.out.println("Thread is running..." + Thread.currentThread().getName() + " : " + isAlive);
        }

    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void terminate() {
        this.isAlive = false;
        System.out.println("Process is terminated... ");
    }
}

public class Volatile {
    public static void main(String[] args) throws InterruptedException {
        Process process = new Process();
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(process);
            thread.start();
        }
        Thread.sleep(3000);
        process.terminate();
        Thread.sleep(3000);
    }
}
