package com.intelliacademy.lesson.cp5.impl.event;

import com.intelliacademy.lesson.env.DataProvider;
import com.intelliacademy.lesson.env.Person;

public class Sequential {
    public static void main(String[] args) {
        var data = DataProvider.provide()
                .stream()
                .map(Person.PersonRoot::of)
                .toList();

        Pipeline<Person.PersonRoot> pipeline = new Pipeline<>();

        var start = System.currentTimeMillis();
        data.forEach(pipeline::produce);
        pipeline.consumeAll();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));
    }
}
