package com.intelliacademy.lesson.cp5.impl.event;

import com.intelliacademy.lesson.env.DataProvider;
import com.intelliacademy.lesson.env.Person;

public class WaitAndNotify {
    public static void main(String[] args) {
        var data = DataProvider.provide()
                .stream()
                .map(Person.PersonRoot::of)
                .toList();


    }
}
