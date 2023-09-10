package com.intelliacademy.lesson.env;

public class GThread extends Thread{
    public GThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public GThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public GThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public GThread(Runnable target, String name) {
        super(target, name);
    }

    public GThread(Runnable target) {
        super(target);
    }

    public GThread(String name) {
        super(name);
    }

    public GThread() {
        super();
    }


}
