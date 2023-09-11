package com.intelliacademy.lesson.cp5.impl.pipeline;

import com.intelliacademy.lesson.env.DataProvider;
import com.intelliacademy.lesson.env.Person;

public class Sequential {
    public static void main(String[] args) {
        var data = DataProvider.provide()
                .stream()
                .toList();

        Pipeline<Person.PersonRoot> pipeline = new Pipeline<>();

        var start = System.currentTimeMillis();
        data.stream().map(Person.PersonRoot::of).forEach(pipeline::produce);
        pipeline.consumeAll();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));
    }
}
