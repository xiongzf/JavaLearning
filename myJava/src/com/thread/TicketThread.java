package com.thread;

public class TicketThread implements Runnable {
    int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
//        method1();
        method2();
        return;
    }

    private void method1() {
        //出售火车票
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + (ticket --));
                }
            }
        }
    }

    private synchronized void method2() {
        //出售火车票
        while (true) {
            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + (ticket --));
            }
        }
    }
}
