package com.intelliacademy.lesson.cp1;

import com.intelliacademy.lesson.env.Person;

public class Main {
    public static void main(String[] args) {
        var person = Person.Prototype.random();
        System.out.println(person.toString());
    }
}
