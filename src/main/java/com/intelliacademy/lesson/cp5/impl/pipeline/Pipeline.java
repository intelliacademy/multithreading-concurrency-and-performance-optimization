package com.intelliacademy.lesson.cp5.impl.pipeline;

import java.util.Queue;

public class Pipeline <T>{
    private final Queue<T> queue = new java.util.LinkedList<>();

    public Queue<T> getQueue() {
        return queue;
    }

    public void produce(T t) {
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + " is producing");
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.add(t);
            this.notify();
        }
    }

    public void consume()  {
        synchronized (this){
            if (queue.isEmpty()){
                System.out.println(Thread.currentThread().getName() + " is waiting");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " is consuming");
            var t = queue.poll();
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
