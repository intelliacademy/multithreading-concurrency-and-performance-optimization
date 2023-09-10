package com.intelliacademy.lesson.cp2.impl;


public class StartingThreadWithThread {
    public static void main(String[] args) {
        XThread t1 = new XThread("t1");
        XThread t2 = new XThread("t2");
        t1.start();
        t2.start();
    }
}

class XThread extends Thread {
    private final String name;
    private Thread listenThread;

    public XThread(String name) {
        this.name = name;
        this.setName(name);
    }

    public void setListenThread(Thread listenThread) {
        this.listenThread = listenThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("%s thread proceed on %d%n", this.getName(), i);
            if (this.listenThread != null)
                System.out.println("State of " + this.listenThread.getName() + " " + this.listenThread.getState());

        }
    }

}
