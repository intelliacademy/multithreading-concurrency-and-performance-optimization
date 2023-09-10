

package com.intelliacademy.lesson.cp2.impl;

public class SequentialProcess1 {
    public static void main(String[] args) {
        printThreadInfo("Execution 1");
        downloadFile();
        openFile();
    }

    public static void printThreadInfo(String message) {
        Thread thread = Thread.currentThread();
        System.out.println("Thread name is ".concat(thread.getName()) +
                " and state is ".concat(thread.getState().name()) +
                " and message is ".concat(message));
    }

    public static void downloadFile() {
        System.out.println("Downloading file with thread ".concat(Thread.currentThread().getName()));
    }

    public static void openFile() {
        System.out.println("Opening file with thread ".concat(Thread.currentThread().getName()));
    }
}
