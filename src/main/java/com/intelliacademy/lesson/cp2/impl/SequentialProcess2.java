

package com.intelliacademy.lesson.cp2.impl;

import com.intelliacademy.lesson.env.Task;

public class SequentialProcess2 {
    public static void main(String[] args) {
        //Sequential execution
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        task1.execute();
        task2.execute();
    }
}
