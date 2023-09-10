package com.intelliacademy.lesson.cp1;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println("Daemon thread proceed on " + i);
            }
        });


    }
}
