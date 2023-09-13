package com.intelliacademy.lesson.cp5.impl.wait;

import java.util.NoSuchElementException;
import java.util.Queue;

public class Pipeline <T>{
    private final Queue<T> queue = new java.util.LinkedList<>();

    private final Object lock = new Object();

    public Queue<T> getQueue() {
        return queue;
    }

    public void produce(T t) {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName() + " is producing");
            queue.add(t);
            this.lock.notify();
        }
    }

    public void consume()  {
        synchronized (lock){
            try {
                queue.remove();
                System.out.println(Thread.currentThread().getName() + " is consuming");
            }catch (NoSuchElementException exception){
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting");
                    this.lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void consumeAll(){
        synchronized (this){
            while (!queue.isEmpty()){
                System.out.println(Thread.currentThread().getName() + " is consuming");
                var t = queue.poll();
            }
        }
    }

}
