package com.intelliacademy.lesson.cp2;

public class Main {
    public static void main(String[] args) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread thread = new Thread(group,()->{
            System.out.println("Hi , This thread name is ".concat(Thread.currentThread().getName()));
        },"XThread");
        thread.start();

    }
}
