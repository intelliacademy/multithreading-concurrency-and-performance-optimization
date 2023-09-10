
package com.intelliacademy.lesson.cp1;

import com.intelliacademy.lesson.env.XRunnable;

public class ThreadLifeCycle {


    public static void main(String[] args) {
        XRunnable xRunnable = new XRunnable();

        Thread thread = new Thread(xRunnable);
        thread.setName("XThread");

        System.out.println("Thread state is ".concat(thread.getState().name()));

        thread.start();

        System.out.println("Thread state is ".concat(thread.getState().name()));
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread state is ".concat(thread.getState().name()));
    }


}
