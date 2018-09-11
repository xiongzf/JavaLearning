package com.thread;

public class Thread1 {
    public static void main(String[] args) {
//        method1();

//        method2();

        TicketThread tt1 = new TicketThread();
        Thread t1 = new Thread(tt1);
        t1.setName("窗口1");
        t1.start();

        TicketThread tt2 = new TicketThread();
        Thread t2 = new Thread(tt1);
        t2.setName("窗口2");
        t2.start();

        TicketThread tt3 = new TicketThread();
        Thread t3 = new Thread(tt1);
        t3.setName("窗口3");
        t3.start();
    }

    private static void method2() {
        MyThread2 mt = new MyThread2();
        Thread t = new Thread(mt);
        t.setName("老王");
        t.start();

        MyThread2 mt2 = new MyThread2();
        Thread t2 = new Thread(mt2);
        t2.setName("你大爷");
        t2.start();
    }

    private static void method1() {
        MyThread mt = new MyThread();
        mt.setName("李四");
        mt.start();

        MyThread mt2 = new MyThread();
        mt2.setName("王五");
        mt2.start();
    }
}
