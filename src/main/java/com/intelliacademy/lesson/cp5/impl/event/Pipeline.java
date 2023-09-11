package com.intelliacademy.lesson.cp5.impl.event;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Pipeline <T>{
    private final Queue<T> queue = new java.util.LinkedList<>();

    public void produce(T t) throws InterruptedException {
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + " is producing");
            Thread.sleep(0);
            queue.add(t);
            this.notify();
        }
    }

    public T consume() throws InterruptedException {
        synchronized (this){
            if (queue.isEmpty()){
                System.out.println(Thread.currentThread().getName() + " is waiting");
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + " is consuming");
            var t = queue.poll();
            return t;
        }
    }

}
