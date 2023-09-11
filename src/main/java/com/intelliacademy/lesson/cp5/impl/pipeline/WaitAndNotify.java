package com.intelliacademy.lesson.cp5.impl.pipeline;

import com.intelliacademy.lesson.env.DataProvider;
import com.intelliacademy.lesson.env.Person;

import java.util.List;

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        var data = DataProvider.provide()
                .stream()
                .toList();

        Pipeline<Person.PersonRoot> pipeline = new Pipeline<>();

        ThreadGroup producingThreadGroup = new ThreadGroup("producing-thread-group");
        producingThreadGroup.setMaxPriority(10);
        ThreadGroup consumingThreadGroup = new ThreadGroup("consuming-thread-group");

        Thread producer1 = new Thread(producingThreadGroup,() -> {
            try {
                iterator(data, pipeline);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"producer-1-thread");

        Thread producer2 = new Thread(producingThreadGroup,() -> {
            try {
                iterator(data, pipeline);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer-2-thread");

        Thread consumer1 = new Thread(consumingThreadGroup,() -> {
            while (true) pipeline.consume();
        }, "consumer-1-thread");

        Thread consumer2 = new Thread(consumingThreadGroup,() -> {
            while (true) pipeline.consume();
        }, "consumer-2-thread");


        consumer1.setDaemon(true);
        consumer2.setDaemon(true);

        var start = System.currentTimeMillis();
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        producer1.join();
        producer2.join();
        System.out.println("Time spent: " + (System.currentTimeMillis() - start));
        System.out.println("Main thread is waiting for all threads to finish");



    }

    private static synchronized void iterator(List<Person> data, Pipeline<Person.PersonRoot> pipeline) throws InterruptedException {
        for (Person person : data) {
            pipeline.produce(Person.PersonRoot.of(person));
        }
    }
}
