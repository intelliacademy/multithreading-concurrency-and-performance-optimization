package com.intelliacademy.lesson.cp2.impl;

public class WaitForThreadsToFinishOnJoinMethod {
    public static void main(String[] args) {
        //We are going to wait for t1 to finish
        XThread t1 = new XThread("T1");
        XThread t2 = new XThread("T2");
        t1.setListenThread(t2);
        t2.setListenThread(t1);
        t1.start();
        t2.start();

        try {
            //JVM will wait for t1 to finish for execution of next line
            t1.join();
            //t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Program is going to terminate");
    }
}
