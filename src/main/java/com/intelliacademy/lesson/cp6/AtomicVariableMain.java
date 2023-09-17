package com.intelliacademy.lesson.cp6;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableMain {

    static class AtomicVariable {
        private AtomicInteger counter = new AtomicInteger(0);

        public void increment() {
            counter.incrementAndGet();
        }

        public int getCounter() {
            return counter.get();
        }

        public void reset() {
            counter.set(0);
        }

        public void decrement() {
            counter.decrementAndGet();
        }
    }


    public static void main(String[] args) {
        AtomicVariable atomicVariable = new AtomicVariable();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicVariable.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicVariable.decrement();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Counter value is %d%n", atomicVariable.getCounter());
    }
}



class NonAtomicVariablesMain {
    static class NonAtomicVariable {
        private int counter = 0;

        public void increment() {
            counter++;
        }

        public int getCounter() {
            return counter;
        }

        public void reset() {
            counter = 0;
        }

        public void decrement() {
            counter--;
        }

    }

    public static void main(String[] args) {
        NonAtomicVariable nonAtomicVariable = new NonAtomicVariable();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                nonAtomicVariable.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                nonAtomicVariable.decrement();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Counter value is %d%n", nonAtomicVariable.getCounter());
    }
}
