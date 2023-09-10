package com.intelliacademy.lesson.env;

public class Task {
    private final String name;
    public Task(String name) {
        this.name = name;
    }

    public void execute(){
        for (int i = 0; i < 100; i++) {
            System.out.println(name + " task proceed on " + i);
        }
    }
}
