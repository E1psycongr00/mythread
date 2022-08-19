package com.example.mythread.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedMyCounter {

    private int cnt = 0;

    private final Object sync1 = new Object();
    public void increase() {
        synchronized (sync1) {
            this.cnt += 1;
        }

    }

    public void decrease() {
        synchronized (sync1) {
            this.cnt -= 1;
        }

    }

    public int getCnt() {
        return this.cnt;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
