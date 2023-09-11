package com.intelliacademy.lesson.cp5.impl.event;

import com.intelliacademy.lesson.env.DataProvider;
import com.intelliacademy.lesson.env.Person;

public class WaitAndNotify {
    public static void main(String[] args) {
        var data = DataProvider.provide()
                .stream()
                .map(Person.PersonRoot::of)
                .toList();

        Pipeline<Person.PersonRoot> pipeline = new Pipeline<>();

        ThreadGroup producingThreadGroup = new ThreadGroup("producing-thread-group");
        ThreadGroup consumingThreadGroup = new ThreadGroup("consuming-thread-group");

        Thread producer1 = new Thread(producingThreadGroup,() -> {
            try {
                for (Person.PersonRoot person : data) {
                    pipeline.produce(person);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"producer-1-thread");

        Thread producer2 = new Thread(producingThreadGroup,() -> {
            try {
                for (Person.PersonRoot person : data) {
                    pipeline.produce(person);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer-2-thread");

        Thread consumer1 = new Thread(consumingThreadGroup,() -> {
            try {
                while (true) {
                    var person = pipeline.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer-1-thread");

        Thread consumer2 = new Thread(consumingThreadGroup,() -> {
            try {
                while (true) {
                    var person = pipeline.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer-2-thread");
        producer1.setPriority(Thread.MAX_PRIORITY);
        producer2.setPriority(Thread.MAX_PRIORITY);

        producer1.start();
        producer2.start();

        consumer1.setDaemon(true);
        consumer2.setDaemon(true);
        consumer1.start();
        consumer2.start();




    }
}
