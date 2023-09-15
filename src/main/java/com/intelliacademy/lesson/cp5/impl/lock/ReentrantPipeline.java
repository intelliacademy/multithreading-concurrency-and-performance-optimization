package com.intelliacademy.lesson.cp5.impl.lock;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantPipeline<T>{
    private final Queue<T> queue = new java.util.LinkedList<>();

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public Queue<T> getQueue() {
        return queue;
    }

    public void produce(T t) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " is producing");
            queue.add(t);
            this.condition.signalAll();
        }finally {
            this.lock.unlock();
        }
    }

    public void consume()  {
        try {
            this.lock.lock();
            queue.remove();
            System.out.println(Thread.currentThread().getName() + " is consuming");
        }catch (NoSuchElementException exception){
            System.out.println(Thread.currentThread().getName() + " is waiting");
            this.lock.unlock();
            try {
                this.condition.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
