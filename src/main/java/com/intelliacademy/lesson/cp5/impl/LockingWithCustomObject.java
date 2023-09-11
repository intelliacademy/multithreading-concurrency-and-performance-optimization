package com.intelliacademy.lesson.cp5.impl;

public class LockingWithCustomObject {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                resource.firstOperation();
            }
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                resource.secondOperation();
            }
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
            System.out.println("First value: " + resource.getFirstValue());
            System.out.println("Second value: " + resource.getSecondValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Resource {
    private final Object firstLock = new Object();
    private final Object secondLock = new Object();

    private Integer firstValue = 0;
    private Integer secondValue = 0;

    /**
     * At the same time execution of this method is possible.
     * But the same time is not parallel execution of this method.
     * CPU use time slicing algorithms to execute this method.
     */
    public void firstOperation() {
        synchronized (firstLock) {
            firstValue++;
        }
    }

    public void secondOperation() {
        synchronized (secondLock) {
            secondValue++;
        }
    }

    public Integer getFirstValue() {
        return firstValue;
    }

    public Integer getSecondValue() {
        return secondValue;
    }
}
