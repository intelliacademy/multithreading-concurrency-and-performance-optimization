package com.intelliacademy.lesson.cp6;

public class AtomicVariable {

}

class NonAtomicVariable {
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

class AtomicVariablesMain{
    public static void main(String[] args) {

    }
}
